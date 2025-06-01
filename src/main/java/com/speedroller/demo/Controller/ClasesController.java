package com.speedroller.demo.Controller;

import com.speedroller.demo.Model.Clase;
import com.speedroller.demo.Service.ClaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clases")
public class ClasesController {

    private final ClaseService claseService;

    public ClasesController(ClaseService claseService) {
        this.claseService = claseService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("clases", claseService.getAllClases());
        return "clases";
    }

    @GetMapping("/crear")
    public String crearClase(Model model) {
        model.addAttribute("clase", new Clase());
        return "clases";
    }

    @PostMapping("/guardar")
    public String guardarClase(@ModelAttribute Clase clase) {
        claseService.saveClase(clase);
        return "redirect:/clases";
    }

    @GetMapping("/editar/{id}")
    public String editarClase(@PathVariable Long id, Model model) {
        Clase clase = claseService.getClaseById(id);
        model.addAttribute("clase", clase);
        return "clases";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarClase(@PathVariable Long id) {
        claseService.deleteClase(id);
        return "redirect:/clases";
    }
}
