package com.HotelSpringBoot.HotelSpring.Models.Service.Factura;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.HotelSpringBoot.HotelSpring.Models.Entity.Factura;

@Service
public interface IFacturaService {

    public List<Factura> findAll();

    public void save(Factura factura);

    public Optional<Factura> findOne(Integer id);

    public void delete(Integer id);
}

