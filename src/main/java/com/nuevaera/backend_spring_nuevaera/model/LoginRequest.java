package com.nuevaera.backend_spring_nuevaera.model;

import jakarta.persistence.*;

public class LoginRequest{
    private String correo;
    private String contrasena;

    public LoginRequest() {}

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
