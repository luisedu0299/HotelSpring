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
@Table(name = "Habitacion")
public class Habitacion implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdHabitacion")
    private Integer idHabitacion;

    @Column(name = "DetalleHabitacion")
    private String detalleHabitacion;

    @Column(name = "EstadoHabitacion")
    private String estadoHabitacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdReserva")
    private Reserva reserva;

    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getDetalleHabitacion() {
        return detalleHabitacion;
    }

    public void setDetalleHabitacion(String detalleHabitacion) {
        this.detalleHabitacion = detalleHabitacion;
    }

    public String getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(String estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    
    
}
