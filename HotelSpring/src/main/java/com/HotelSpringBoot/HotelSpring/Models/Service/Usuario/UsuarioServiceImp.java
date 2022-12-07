package com.HotelSpringBoot.HotelSpring.Models.Service.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HotelSpringBoot.HotelSpring.Models.Dao.IUsuarioDao;
import com.HotelSpringBoot.HotelSpring.Models.Entity.Usuario;


@Service
public class UsuarioServiceImp implements IUsuarioService, UserDetailsService{

    @Autowired
    private IUsuarioDao usuarioDao;

    @Autowired
    BCryptPasswordEncoder enco;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return usuarioDao.findAll();
    }

    @Override
    public void save(Usuario usuario) {
        usuario.setPassword(enco.encode(usuario.getPassword()));
        usuarioDao.save(usuario);
        
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> findOne(Long id) {
        return usuarioDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        usuarioDao.deleteById(id);
        
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario us = usuarioDao.findOneByUserName(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(us.getRol()));
        UserDetails usern = new User(us.getUserName(), us.getPassword(), roles);
        return usern;
    }

    
}
