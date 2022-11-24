package com.HotelSpringBoot.HotelSpring.Models.Service.Reserva;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.HotelSpringBoot.HotelSpring.Models.Entity.Reserva;



@Service
public interface IReservaService {
    
    public List<Reserva> findAll();

    public void save(Reserva reserva);

    public Optional<Reserva> findOne(Integer id);

    public void delete(Integer id);
}
