package com.ucema.progra3ucemabackend.services;

import com.ucema.progra3ucemabackend.model.*;

import java.util.Optional;

public interface UsuarioService {
    
    Alumno createAlumno(Alumno alumno);

    Profesor createProfesor(Profesor profesor);

    Usuario updateUsuario(Usuario usuario);

    boolean deleteUsuario(Usuario usuario);

    Optional<Usuario> getByUsername(String username);

    String authenticate(String username, String password);

    Usuario getUserInfo();
}
