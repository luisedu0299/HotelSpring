package com.HotelSpringBoot.HotelSpring.Models.Service.Factura;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.HotelSpringBoot.HotelSpring.Models.Dao.IFacturaDao;
import com.HotelSpringBoot.HotelSpring.Models.Entity.Factura;



@Service
public class FacturaServiceImp implements IFacturaService{

    @Autowired
    private IFacturaDao ftr;

    @Transactional(readOnly = true)
    @Override
    public List<Factura> findAll(){
        return (List<Factura>)ftr.findAll();
    }

    @Override
    public void save(Factura factura) {
        ftr.save(factura);
        
    }

    @Override
    public Optional<Factura> findOne(Integer id) {
        return ftr.findById(id);
    }

    @Override
    public void delete(Integer id) {
        ftr.deleteById(id);
        
    }
    
}
