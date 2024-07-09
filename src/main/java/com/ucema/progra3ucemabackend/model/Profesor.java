package com.ucema.progra3ucemabackend.model;

import com.ucema.progra3ucemabackend.repositories.EtiquetaRepository;
import com.ucema.progra3ucemabackend.repositories.PostRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "profesores")
public class Profesor extends Usuario {

    public Profesor() {
    }

    public Profesor(String username, String name, String email, String password) {
        super(username, name, email, password);
    }

    @Override
    public String getRole() {
        return "PROFESOR";
    }

    public void borrarPost(Post post, PostRepository postRepository) {
        postRepository.delete(post);
    }

    public Etiqueta crearEtiqueta(String nombre, EtiquetaRepository etiquetaRepository) {
        Etiqueta nuevaEtiqueta = new Etiqueta(nombre);
        return etiquetaRepository.save(nuevaEtiqueta);
    }

}

