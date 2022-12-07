package com.HotelSpringBoot.HotelSpring.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.HotelSpringBoot.HotelSpring.Models.Entity.Usuario;
import com.HotelSpringBoot.HotelSpring.Models.Service.Usuario.IUsuarioService;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;
    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("usuarios", usuarioService.findAll());
        model.addAttribute("titulo", "Usuarios");
        return "pages/usuario/listarUsuario";
    }

    @GetMapping("/form")
    public String formularioRender(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("titulo", "Crear Usuario");
        return "pages/usuario/registrarUsuario";
    }

    @PostMapping ("/form")//peticion para guarda los datos en db
    public String guardar (@Valid Usuario usuario, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("titulo", "formulario de usuario");
            return "form";
        }
        usuarioService.save(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        if(id>0){
            usuarioService.delete(id);
        }
        return "redirect:/usuario/listar";
    }

    @GetMapping("/actualizar/{id}")
    public String actualizarUsuario(@PathVariable Long id,Model model) {
        Optional<Usuario> usuario = usuarioService.findOne(id);
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Actualizar Usuario");
        return "pages/usuario/registrarUsuario";
    }
}

