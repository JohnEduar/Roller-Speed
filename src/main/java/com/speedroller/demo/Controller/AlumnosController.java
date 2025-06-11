package com.speedroller.demo.Controller;

import com.speedroller.demo.Model.Alumno;
import com.speedroller.demo.Service.AlumnoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@Tag(name = "Alumnos", description = "Controlador para gestionar alumnos")
@Controller
@RequestMapping("/alumnos")
public class AlumnosController {

    private final AlumnoService alumnoService;

    public AlumnosController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @Operation(summary = "Mostrar lista de alumnos", description = "Obtiene todos los alumnos y los muestra en la vista", responses = {
        @ApiResponse(responseCode = "200", description = "Lista de alumnos mostrada correctamente",
        content = @Content(schema = @Schema(implementation = Alumno.class))),
        @ApiResponse(responseCode = "404", description = "No se encontraron alumnos")
    })

    @GetMapping
    public String index(Model model) {
        model.addAttribute("alumnos", alumnoService.getAllAlumnos());
        return "alumnos";
    }

    @Operation(summary = "Guardar alumno", description = "Guarda un nuevo alumno o actualiza uno existente", responses = {
        @ApiResponse(responseCode = "200", description = "Alumno guardado correctamente",
        content = @Content(schema = @Schema(implementation = Alumno.class))),
        @ApiResponse(responseCode = "404", description = "No se encontró la vista del formulario")
    })

    @PostMapping("/guardar")
    public String guardarAlumno(@ModelAttribute Alumno alumno) {
        alumnoService.saveAlumno(alumno);
        return "redirect:/alumnos";
    }

    @Operation(summary = "Editar alumno", description = "Obtiene los datos de un alumno por su ID y los muestra en el formulario para editar", responses = {
    @ApiResponse(responseCode = "200", description = "Formulario de edición mostrado correctamente",
    content = @Content(schema = @Schema(implementation = Alumno.class))),
    @ApiResponse(responseCode = "404", description = "Alumno no encontrado")
})

    @GetMapping("/editar/{id}")
    public String editarAlumno(@PathVariable Long id, Model model) {
    Alumno alumno = alumnoService.getAlumnoById(id); 
    model.addAttribute("alumno", alumno); 
    return "alumnos"; 
    }

    @Operation(summary = "Eliminar alumno", description = "Elimina un alumno por su ID", responses = {
        @ApiResponse(responseCode = "200", description = "Alumno eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Alumno no encontrado")
    })

    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable Long id) {
        alumnoService.deleteAlumno(id);
        return "redirect:/alumnos";
    }

}