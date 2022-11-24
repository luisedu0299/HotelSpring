package com.HotelSpringBoot.HotelSpring.Models.Service.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.HotelSpringBoot.HotelSpring.Models.Dao.IServicioDao;
import com.HotelSpringBoot.HotelSpring.Models.Entity.Servicio;


@Service
public class ServicioServiceImp implements IServicioService{
    @Autowired
    private IServicioDao servi;

    @Transactional(readOnly = true)
    @Override
    public List<Servicio> findAll() {
        return (List<Servicio>)servi.findAll();
    }

    @Override
    public void save(Servicio servicio) {
        servi.save(servicio);
        
    }

    @Override
    public Optional<Servicio> findOne(Integer id) {
        return servi.findById(id);
    }

    @Override
    public void delete(Integer id) {
        servi.deleteById(id);
        
    }
}
