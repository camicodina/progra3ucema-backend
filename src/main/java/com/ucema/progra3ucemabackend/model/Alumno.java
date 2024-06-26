package com.ucema.progra3ucemabackend.model;

import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Entity
public class Alumno extends Usuario {
    private String carrera;
    private String año;

    public Alumno(String username, String name, String email, String password, String carrera, String año) {
        super(username, name, email, password);
        this.carrera = carrera;
        this.año = año;
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

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ALUMNO"));
//        return authorities;
//    }

}

