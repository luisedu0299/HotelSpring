package com.HotelSpringBoot.HotelSpring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping("/index")
    public String primerTemplate(){
        return "templateImplementador";
    }
}
