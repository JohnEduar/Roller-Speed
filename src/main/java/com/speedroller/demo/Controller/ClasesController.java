package com.speedroller.demo.Controller;

import com.speedroller.demo.Model.Clase;
import com.speedroller.demo.Service.ClaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Clases", description = "Controlador para gestionar clases")
@Controller
@RequestMapping("/clases")
public class ClasesController {

    private final ClaseService claseService;

    public ClasesController(ClaseService claseService) {
        this.claseService = claseService;
    }

    @Operation(summary = "Mostrar lista de clases", description = "Obtiene todas las clases y las muestra en la vista", responses = {
        @ApiResponse(responseCode = "200", description = "Lista de clases mostrada correctamente",
        content = @Content(schema = @Schema(implementation = Clase.class))),
        @ApiResponse(responseCode = "404", description = "No se encontraron clases")
    })
    @GetMapping
    public String index(Model model) {
        model.addAttribute("clases", claseService.getAllClases());
        return "clases";
    }

    @Operation(summary = "Crear clase", description = "Muestra el formulario para crear una nueva clase", responses = {
        @ApiResponse(responseCode = "200", description = "Formulario mostrado correctamente"),
        @ApiResponse(responseCode = "404", description = "No se encontró la vista del formulario")
    })
    @GetMapping("/crear")
    public String crearClase(Model model) {
        model.addAttribute("clase", new Clase());
        return "clases";
    }

    @Operation(summary = "Guardar clase", description = "Guarda una nueva clase o actualiza una existente", responses = {
        @ApiResponse(responseCode = "200", description = "Clase guardada correctamente",
        content = @Content(schema = @Schema(implementation = Clase.class))),
        @ApiResponse(responseCode = "404", description = "No se encontró la vista del formulario")
    })
    @PostMapping("/guardar")
    public String guardarClase(@ModelAttribute Clase clase) {
        claseService.saveClase(clase);
        return "redirect:/clases";
    }

    @Operation(summary = "Editar clase", description = "Obtiene los datos de una clase por su ID y los muestra en el formulario para editar", responses = {
        @ApiResponse(responseCode = "200", description = "Formulario de edición mostrado correctamente",
        content = @Content(schema = @Schema(implementation = Clase.class))),
        @ApiResponse(responseCode = "404", description = "Clase no encontrada")
    })
    @GetMapping("/editar/{id}")
    public String editarClase(@PathVariable Long id, Model model) {
        Clase clase = claseService.getClaseById(id);
        model.addAttribute("clase", clase);
        return "clases";
    }

    @Operation(summary = "Eliminar clase", description = "Elimina una clase por su ID", responses = {
        @ApiResponse(responseCode = "200", description = "Clase eliminada correctamente"),
        @ApiResponse(responseCode = "404", description = "Clase no encontrada")
    })
    @GetMapping("/eliminar/{id}")
    public String eliminarClase(@PathVariable Long id) {
        claseService.deleteClase(id);
        return "redirect:/clases";
    }
}

