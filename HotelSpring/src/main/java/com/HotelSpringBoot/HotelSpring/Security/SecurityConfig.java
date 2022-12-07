package com.HotelSpringBoot.HotelSpring.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


import com.HotelSpringBoot.HotelSpring.Models.Service.Usuario.UsuarioServiceImp;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private UsuarioServiceImp userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        
        http.formLogin().defaultSuccessUrl("/", true);
        return http.build();
    }
}
