package com.speedroller.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnosController {
    @GetMapping
    public String index() {
        return "alumnos";
    }
}