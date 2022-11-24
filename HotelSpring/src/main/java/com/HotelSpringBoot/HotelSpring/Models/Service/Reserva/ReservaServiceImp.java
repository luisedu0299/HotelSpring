package com.HotelSpringBoot.HotelSpring.Models.Service.Reserva;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.HotelSpringBoot.HotelSpring.Models.Dao.IReservaDao;
import com.HotelSpringBoot.HotelSpring.Models.Entity.Reserva;



@Service
public class ReservaServiceImp implements IReservaService{
    
    @Autowired
    private IReservaDao reser;

    @Transactional(readOnly = true)
    @Override
    public List<Reserva> findAll() {
        return (List<Reserva>)reser.findAll();
    }

    @Override
    public void save(Reserva reserva) {
        reser.save(reserva);
        
    }

    @Override
    public Optional<Reserva> findOne(Integer id) {
        return reser.findById(id);
    }

    @Override
    public void delete(Integer id) {
        reser.deleteById(id);
        
    }
}

