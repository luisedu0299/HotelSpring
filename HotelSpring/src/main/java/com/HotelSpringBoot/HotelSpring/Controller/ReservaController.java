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
import com.HotelSpringBoot.HotelSpring.Models.Entity.Reserva;
import com.HotelSpringBoot.HotelSpring.Models.Service.Factura.IFacturaService;
import com.HotelSpringBoot.HotelSpring.Models.Service.Reserva.IReservaService;
import com.HotelSpringBoot.HotelSpring.Models.Service.Usuario.IUsuarioService;




@Controller
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private IReservaService reservaSer;

    @Autowired
    private IUsuarioService userSer;

    @Autowired
    private IFacturaService facturSer;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("reservas", reservaSer.findAll());
        model.addAttribute("titulo", "Reservas");
        return "pages/reserva/listarReserva";
    }

    @GetMapping("/form")
    public String formularioRender(Model model) {
        model.addAttribute("facturas", facturSer.findAll());
        model.addAttribute("usuarios", userSer.findAll());
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("titulo", "Crear Reserva");
        return "pages/reserva/registrarReserva";
    }

    @PostMapping("/form")
    public String validarReserva(@Validated Reserva reserva, Model model) {
        reservaSer.save(reserva);
        return "redirect:/reserva/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Integer id) {
        if (id > 0) {
            reservaSer.delete(id);
        }
        return "redirect:/reserva/listar";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizarReserva(@PathVariable Integer id, Model model) {
        Optional<Reserva> reserva = reservaSer.findOne(id);
        model.addAttribute("reserva", reserva);
        model.addAttribute("titulo", "Actualizar Reserva");
        model.addAttribute("facturas", facturSer.findAll());
        model.addAttribute("usuarios", userSer.findAll());
        return "pages/reserva/registrarReserva";
    }
}

