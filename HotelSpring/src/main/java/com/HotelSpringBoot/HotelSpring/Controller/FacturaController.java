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
import com.HotelSpringBoot.HotelSpring.Models.Entity.Factura;
import com.HotelSpringBoot.HotelSpring.Models.Service.Factura.IFacturaService;
import com.HotelSpringBoot.HotelSpring.Models.Service.Servicio.IServicioService;




@Controller
@RequestMapping("/factura")
public class FacturaController {
    @Autowired
    private IFacturaService factSer;
    @Autowired
    private IServicioService serSer;
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("servicios", serSer.findAll());
        model.addAttribute("facturas", factSer.findAll());
        model.addAttribute("titulo", "Facturas");
        return "pages/factura/listarFactura";
    }

    @GetMapping("/form")
    public String formularioRender(Model model) {
        model.addAttribute("factura", new Factura());
        model.addAttribute("servicios", serSer.findAll());
        model.addAttribute("titulo", "Crear Reserva");
        return "pages/factura/registrarFactura";
    }

    @PostMapping("/form")
    public String validarFactura(@Validated Factura factura, Model model) {
        factSer.save(factura);
        return "redirect:/factura/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFactura(@PathVariable Integer id) {
        if (id > 0) {
            factSer.delete(id);
        }
        return "redirect:/factura/listar";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizarFactura(@PathVariable Integer id, Model model) {
        Optional<Factura> factura = factSer.findOne(id);
        model.addAttribute("servicios", serSer.findAll());
        model.addAttribute("factura", factura);
        model.addAttribute("titulo", "Actualizar Factura");
        return "pages/factura/registrarFactura";
    }
}
