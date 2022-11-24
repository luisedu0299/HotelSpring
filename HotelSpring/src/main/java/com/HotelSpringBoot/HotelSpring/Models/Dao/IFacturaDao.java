package com.HotelSpringBoot.HotelSpring.Models.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.HotelSpringBoot.HotelSpring.Models.Entity.Factura;
        
@Repository
public interface IFacturaDao extends JpaRepository<Factura, Integer> {
        
}
