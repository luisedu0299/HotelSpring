package com.HotelSpringBoot.HotelSpring.Models.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Servicio")
public class Servicio implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdServicio")
    private Integer idServicio;

    @Column(name = "TipoServicio")
    private String tipoServicio;

    @Column(name = "DetalleServicio") 
    private String detalleServicio;

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getDetalleServicio() {
        return detalleServicio;
    }

    public void setDetalleServicio(String detalleServicio) {
        this.detalleServicio = detalleServicio;
    }

}
