package com.speedroller.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.speedroller.demo.Model.Instructor;
import java.util.Optional;


public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Optional<Instructor> findByIdentificacion(String identificacion);
}


