package com.speedroller.demo.Controller;

import com.speedroller.demo.Model.Instructor;
import com.speedroller.demo.Service.InstructorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/instructores")
public class InstructoresController {

    private final InstructorService instructorService;

    public InstructoresController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("instructores", instructorService.getAllInstructors());
        return "instructores";
    }

    @GetMapping("/crear")
    public String crearInstructor(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructores";
    }

    @PostMapping("/guardar")
    public String guardarInstructor(@ModelAttribute Instructor instructor) {
        instructorService.saveInstructor(instructor);
        return "redirect:/instructores";
    }

    @GetMapping("/editar/{id}")
    public String editarInstructor(@PathVariable Long id, Model model) {
        Instructor instructor = instructorService.getInstructorById(id);
        model.addAttribute("instructor", instructor);
        return "instructores";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return "redirect:/instructores";
    }
}