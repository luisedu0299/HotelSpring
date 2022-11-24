package com.HotelSpringBoot.HotelSpring.Models.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Factura")
public class Factura implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdFactura")
    private Integer idFactura;

    @Column(name = "CostoFactura")
    private Integer costoFactura;

    @Column(name = "DetalleFactura") 
    private String detalleFactura;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdServicio")
    private Servicio servicio;



    public Integer getCostoFactura() {
        return costoFactura;
    }

    public void setCostoFactura(Integer costoFactura) {
        this.costoFactura = costoFactura;
    }

    public String getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(String detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

   

}

