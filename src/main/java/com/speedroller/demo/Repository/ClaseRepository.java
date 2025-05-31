package com.speedroller.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.speedroller.demo.Model.Clase;
import java.util.Optional;


public interface ClaseRepository extends JpaRepository<Clase, Long> {
    Optional<Clase> findByNombre(String nombre);
}