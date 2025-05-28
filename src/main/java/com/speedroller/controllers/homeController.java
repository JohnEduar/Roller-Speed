package com.speedroller.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class homeController {

    @GetMapping("home")
    public String mostrarInicio() {
        return "home";
    }

    @GetMapping("eventos")
    public String mostrarEventos() {
        return "eventos";
    }

    @GetMapping("mision")
    public String mostrarMision() {
        return "mision";
    }

    @GetMapping("vision")
    public String mostrarVision() {
        return "vision";
    }

    @GetMapping("valores")
    public String mostrarValores() {
        return "valores";
    }
}

