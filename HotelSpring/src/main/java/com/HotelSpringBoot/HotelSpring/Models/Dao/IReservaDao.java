package com.HotelSpringBoot.HotelSpring.Models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.HotelSpringBoot.HotelSpring.Models.Entity.Reserva;


public interface IReservaDao extends JpaRepository<Reserva, Integer>{
    
}
