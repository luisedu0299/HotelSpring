package com.HotelSpringBoot.HotelSpring.Models.Service.Habitacion;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.HotelSpringBoot.HotelSpring.Models.Dao.IHabitacionDao;
import com.HotelSpringBoot.HotelSpring.Models.Entity.Habitacion;




@Service
public class HabitacionServiceImp implements IHabitacionService{

    @Autowired
    private IHabitacionDao habita;

    @Transactional(readOnly = true)
    @Override
    public List<Habitacion> findAll() {
        return (List<Habitacion>)habita.findAll();
    }

    @Override
    public void save(Habitacion habitacion) {
        habita.save(habitacion);
        
    }

    @Override
    public Optional<Habitacion> findOne(Integer id) {
        return habita.findById(id);
    }

    @Override
    public void delete(Integer id) {
        habita.deleteById(id);
        
    }
}
