package com.speedroller.demo.Model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Clase {
    @Id
    private Long id;
    private String nombre;
    private String descripcion;
    private String horario;
    private String nivel;
    private BigDecimal precio;

    public Clase() {
    }

    public Clase(Long id, String nombre, String descripcion, String horario, String nivel, BigDecimal precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horario = horario;
        this.nivel = nivel;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}