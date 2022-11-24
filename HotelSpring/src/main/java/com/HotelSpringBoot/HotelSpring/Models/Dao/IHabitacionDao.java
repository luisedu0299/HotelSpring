package com.HotelSpringBoot.HotelSpring.Models.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.HotelSpringBoot.HotelSpring.Models.Entity.Habitacion;



@Repository
public interface IHabitacionDao extends JpaRepository<Habitacion, Integer> {
    
}
