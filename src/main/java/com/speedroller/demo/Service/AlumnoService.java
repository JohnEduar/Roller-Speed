package com.speedroller.demo.Service;

import com.speedroller.demo.Model.Alumno;
import com.speedroller.demo.Repository.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    public Alumno getAlumnoByIdentificacion(String identificacion) {
        return alumnoRepository.findByIdentificacion(identificacion).orElse(null);
    }

    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void deleteAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }

    public Alumno getAlumnoById(Long id) {
    return alumnoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado con ID: " + id));
}
}