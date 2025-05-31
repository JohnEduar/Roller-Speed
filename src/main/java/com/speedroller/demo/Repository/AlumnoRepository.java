package com.speedroller.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.speedroller.demo.Model.Alumno;
import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    Optional<Alumno> findByIdentificacion(String identificacion);
}
