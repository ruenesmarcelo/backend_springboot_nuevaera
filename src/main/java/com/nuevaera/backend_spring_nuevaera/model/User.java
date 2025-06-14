package com.nuevaera.backend_spring_nuevaera.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // debe coincidir con el nombre exacto de tu tabla
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //-- esta linea se usa por si se quiere asignar un id por defecto
    private String id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false )
    private int id_rol;

    @Column(nullable = false, length = 100)
    private String correo;

    @Column(nullable = false, length = 15)
    private String telefono;

    @Column(nullable = false, length = 150)
    private String direccion;

    @Column( length = 255)
    private String contrasena;

    // Constructor vacío requerido por JPA
    public User() { }

    public User(String id, String nombre, String apellido, int id_rol, String correo, String telefono, String direccion, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_rol = id_rol;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contrasena = contrasena;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getId_rol() {
        return id_rol;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
