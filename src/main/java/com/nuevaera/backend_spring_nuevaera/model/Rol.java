package com.nuevaera.backend_spring_nuevaera.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rol;

    @Column(nullable = false, length = 50)
    private String descripcion;

    public Rol() { }

    public Rol(int  id_rol, String Descripcion) {
        this.id_rol = id_rol;
        this.descripcion = descripcion;
    }

    public int getId_rol() {
        return id_rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}