package com.HotelSpringBoot.HotelSpring.Models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.HotelSpringBoot.HotelSpring.Models.Entity.Usuario;

@Repository
public interface IUsuarioDao extends JpaRepository<Usuario, Long>{
    
    Usuario findOneByUserName(String nombreUsuario);
}
