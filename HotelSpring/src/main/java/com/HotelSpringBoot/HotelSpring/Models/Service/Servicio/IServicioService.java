package com.HotelSpringBoot.HotelSpring.Models.Service.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.HotelSpringBoot.HotelSpring.Models.Entity.Servicio;

@Service
public interface IServicioService {
    
    public List<Servicio> findAll();

    public void save (Servicio servicio);

    public Optional<Servicio> findOne(Integer id);

    public void delete (Integer id);
}

