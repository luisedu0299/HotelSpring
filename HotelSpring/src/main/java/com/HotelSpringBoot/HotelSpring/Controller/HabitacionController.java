package com.HotelSpringBoot.HotelSpring.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.HotelSpringBoot.HotelSpring.Models.Entity.Habitacion;
import com.HotelSpringBoot.HotelSpring.Models.Service.Habitacion.IHabitacionService;
import com.HotelSpringBoot.HotelSpring.Models.Service.Reserva.IReservaService;




@Controller
@RequestMapping("/habitacion")
public class HabitacionController {
    @Autowired
    private IHabitacionService habitacionSer;

    @Autowired
    private IReservaService reservaSer;


    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("habitaciones", habitacionSer.findAll());
        model.addAttribute("titulo", "Habitaciones");
        return "pages/habitacion/listarHabitacion";
    }

    @GetMapping("/form")
    public String formularioRender(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        model.addAttribute("reservas", reservaSer.findAll());
        model.addAttribute("titulo", "Crear Habitacion");
        return "pages/habitacion/registrarHabitacion";
    }

    @PostMapping("/form")
    public String validarReserva(@Validated Habitacion habitacion, Model model) {
        habitacionSer.save(habitacion);
        return "redirect:/habitacion/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarHabitacion(@PathVariable Integer id) {
        if (id > 0) {
            habitacionSer.delete(id);
        }
        return "redirect:/habitacion/listar";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizarHabitacion(@PathVariable Integer id, Model model) {
        Optional<Habitacion> habitacion = habitacionSer.findOne(id);
        model.addAttribute("habitacion", habitacion);
        model.addAttribute("titulo", "Actualizar Habitacion");
        model.addAttribute("reservas", reservaSer.findAll());
        return "pages/habitacion/registrarHabitacion";
    }
}
