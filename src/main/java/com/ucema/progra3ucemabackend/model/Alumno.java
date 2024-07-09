package com.ucema.progra3ucemabackend.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "alumnos")
public class Alumno extends Usuario {

    private String carrera;
    private String año;

    public Alumno(String username, String name, String email, String password, String carrera, String año) {
        super(username, name, email, password);
        this.carrera = carrera;
        this.año = año;
    }

    public Alumno() {
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }


    @Override
    public String getRole() {
        return "ALUMNO";
    }

}

