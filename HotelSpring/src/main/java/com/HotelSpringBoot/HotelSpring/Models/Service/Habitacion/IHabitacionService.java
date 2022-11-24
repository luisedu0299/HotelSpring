package com.HotelSpringBoot.HotelSpring.Models.Service.Habitacion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.HotelSpringBoot.HotelSpring.Models.Entity.Habitacion;

@Service
public interface IHabitacionService {

    public List<Habitacion> findAll();

    public void save(Habitacion habitacion);

    public Optional<Habitacion> findOne(Integer id);

    public void delete(Integer id);
}
