package com.model;

import java.time.LocalDate;

public class Profesor extends Usuario {
    private LocalDate fechaIngreso;

    public Profesor(String username, String name, String email, String password) {
        super(username, name, email, password);
    }

    public void BorrarPost(Post post){
        
    }
}
