package com.ucema.progra3ucemabackend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "profesores")
public class Profesor extends Usuario {

    public Profesor() {
    }

    public Profesor(String username, String name, String email, String password) {
        super(username, name, email, password);
    }

    // Implementación de GrantedAuthority

    @Override
    public String getRole() {
        return "PROFESOR";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("PROFESOR"));
        return authorities;
    }

    
}

