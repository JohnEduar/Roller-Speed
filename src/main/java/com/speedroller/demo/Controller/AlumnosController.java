package com.speedroller.demo.Controller;

import com.speedroller.demo.Model.Alumno;
import com.speedroller.demo.Service.AlumnoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alumnos")
public class AlumnosController {

    private final AlumnoService alumnoService;

    public AlumnosController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("alumnos", alumnoService.getAllAlumnos());
        return "alumnos";
    }

    @PostMapping("/guardar")
    public String guardarAlumno(@ModelAttribute Alumno alumno) {
        alumnoService.saveAlumno(alumno);
        return "redirect:/alumnos";
    }

    @GetMapping("/editar/{id}")
    public String editarAlumno(@PathVariable Long id, Model model) {
    Alumno alumno = alumnoService.getAlumnoById(id); 
    model.addAttribute("alumno", alumno); 
    return "alumnos"; 
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable Long id) {
        alumnoService.deleteAlumno(id);
        return "redirect:/alumnos";
    }

}