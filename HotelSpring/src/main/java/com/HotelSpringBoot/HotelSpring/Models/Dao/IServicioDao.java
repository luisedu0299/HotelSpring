package com.HotelSpringBoot.HotelSpring.Models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.HotelSpringBoot.HotelSpring.Models.Entity.Servicio;

public interface IServicioDao extends JpaRepository<Servicio, Integer>{
    
}
