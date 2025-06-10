package com.speedroller.demo.Controller;

import com.speedroller.demo.Model.Instructor;
import com.speedroller.demo.Service.InstructorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Instructores", description = "Controlador para gestionar instructores")
@Controller
@RequestMapping("/instructores")
public class InstructoresController {

    private final InstructorService instructorService;

    public InstructoresController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @Operation(summary = "Mostrar lista de instructores", description = "Obtiene todos los instructores y los muestra en la vista", responses = {
        @ApiResponse(responseCode = "200", description = "Lista de instructores mostrada correctamente",
        content = @Content(schema = @Schema(implementation = Instructor.class))),
        @ApiResponse(responseCode = "404", description = "No se encontraron instructores")
    })
    @GetMapping
    public String index(Model model) {
        model.addAttribute("instructores", instructorService.getAllInstructors());
        return "instructores";
    }

    @Operation(summary = "Crear instructor", description = "Muestra el formulario para crear un nuevo instructor", responses = {
        @ApiResponse(responseCode = "200", description = "Formulario mostrado correctamente"),
        @ApiResponse(responseCode = "404", description = "No se encontró la vista del formulario")
    })
    @GetMapping("/crear")
    public String crearInstructor(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructores";
    }

    @Operation(summary = "Guardar instructor", description = "Guarda un nuevo instructor o actualiza uno existente", responses = {
        @ApiResponse(responseCode = "200", description = "Instructor guardado correctamente",
        content = @Content(schema = @Schema(implementation = Instructor.class))),
        @ApiResponse(responseCode = "404", description = "No se encontró la vista del formulario")
    })
    @PostMapping("/guardar")
    public String guardarInstructor(@ModelAttribute Instructor instructor) {
        instructorService.saveInstructor(instructor);
        return "redirect:/instructores";
    }

    @Operation(summary = "Editar instructor", description = "Obtiene los datos de un instructor por su ID y los muestra en el formulario para editar", responses = {
        @ApiResponse(responseCode = "200", description = "Formulario de edición mostrado correctamente",
        content = @Content(schema = @Schema(implementation = Instructor.class))),
        @ApiResponse(responseCode = "404", description = "Instructor no encontrado")
    })
    @GetMapping("/editar/{id}")
    public String editarInstructor(@PathVariable Long id, Model model) {
        Instructor instructor = instructorService.getInstructorById(id);
        model.addAttribute("instructor", instructor);
        return "instructores";
    }

    @Operation(summary = "Eliminar instructor", description = "Elimina un instructor por su ID", responses = {
        @ApiResponse(responseCode = "200", description = "Instructor eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Instructor no encontrado")
    })
    @GetMapping("/eliminar/{id}")
    public String eliminarInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return "redirect:/instructores";
    }
}