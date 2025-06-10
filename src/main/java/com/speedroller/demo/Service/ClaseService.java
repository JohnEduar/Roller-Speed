package com.speedroller.demo.Service;

import com.speedroller.demo.Model.Clase;
import com.speedroller.demo.Repository.ClaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseService {

    private final ClaseRepository claseRepository;

    public ClaseService(ClaseRepository claseRepository) {
        this.claseRepository = claseRepository;
    }

    public List<Clase> getAllClases() {
        return claseRepository.findAll();
    }

    public Clase getClaseByNombre(String nombre) {
        return claseRepository.findByNombre(nombre).orElse(null);
    }

    public Clase saveClase(Clase clase) {
        return claseRepository.save(clase);
    }

    public void deleteClase(Long id) {
        claseRepository.deleteById(id);
    }

    public Clase getClaseById(Long id) {
        return claseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Clase no encontrada con ID: " + id));
    }
}