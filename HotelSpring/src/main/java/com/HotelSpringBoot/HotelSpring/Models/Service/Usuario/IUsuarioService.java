package com.HotelSpringBoot.HotelSpring.Models.Service.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.HotelSpringBoot.HotelSpring.Models.Entity.Usuario;

@Service
public interface IUsuarioService {
    
    public List<Usuario> findAll();

    public void save(Usuario usuario);

    public Optional<Usuario> findOne(Integer id);

    public void delete(Integer id);
}
