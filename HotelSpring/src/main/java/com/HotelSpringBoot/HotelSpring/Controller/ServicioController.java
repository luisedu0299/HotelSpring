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
import com.HotelSpringBoot.HotelSpring.Models.Entity.Servicio;
import com.HotelSpringBoot.HotelSpring.Models.Service.Servicio.IServicioService;





@Controller
@RequestMapping("/servicio")
public class ServicioController {
    @Autowired
    private IServicioService serv;
    @GetMapping("/listar")
    public String listar(Model model){
        
        model.addAttribute("servicios", serv.findAll());
        model.addAttribute("titulo", "Servicios");
        return "pages/servicio/listarServicio";
    }

    @GetMapping("/form")
    public String formularioRender(Model model) {
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("titulo", "Crear Servicio");
        return "pages/servicio/registrarServicio";
    }

    @PostMapping("/form")
    public String validarServicio(@Validated Servicio servicio, Model model) {
        serv.save(servicio);
        return "redirect:/servicio/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarServicio(@PathVariable Integer id) {
        if(id>0){
            serv.delete(id);
        }
        return "redirect:/servicio/listar";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizarServicio(@PathVariable Integer id,Model model) {
        Optional<Servicio> servicio = serv.findOne(id);
        model.addAttribute("servicio", servicio);
        model.addAttribute("titulo", "Actualizar Servicio");
        return "pages/servicio/registrarServicio";
    }
}
