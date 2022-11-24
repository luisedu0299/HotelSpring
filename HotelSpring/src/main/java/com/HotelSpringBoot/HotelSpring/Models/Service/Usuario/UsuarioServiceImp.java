package com.HotelSpringBoot.HotelSpring.Models.Service.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.HotelSpringBoot.HotelSpring.Models.Dao.IUsuarioDao;
import com.HotelSpringBoot.HotelSpring.Models.Entity.Usuario;


@Service
public class UsuarioServiceImp implements IUsuarioService{

    @Autowired
    private IUsuarioDao user;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>)user.findAll();
    }

    @Override
    public void save(Usuario usuario) {
        user.save(usuario);
        
    }

    @Override
    public Optional<Usuario> findOne(Integer id) {
        return user.findById(id);
    }

    @Override
    public void delete(Integer id) {
        user.deleteById(id);
        
    }
    
}
