package com.HotelSpringBoot.HotelSpring.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    @GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response){

        Authentication aut = SecurityContextHolder.getContext().getAuthentication();
        if (aut != null){
            new SecurityContextLogoutHandler().logout(request, response, aut);
            aut = null;
        } 
        return "redirest:login?logout";
    }

    @GetMapping("/")
    public String redirect(){

        Authentication aut = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(aut.getPrincipal());
        if(aut.getPrincipal().equals("anonymousUser")){
            return "redirect:/login?logout";
        }
        else{
            return "index.html";
        }
    }
}
