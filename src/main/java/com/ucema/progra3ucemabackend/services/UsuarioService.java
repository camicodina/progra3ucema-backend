package com.ucema.progra3ucemabackend.services;

import com.ucema.progra3ucemabackend.model.*;

public interface UsuarioService {
    
    Alumno createAlumno(String username, String name, String email, String password, String carrera, String año);

    Profesor createProfesor(String username, String name, String email, String password);

    Usuario updateUsuario(Usuario usuario);

    boolean deleteUsuario(Usuario usuario);

    Optional<Usuario> getByUsername(String username);
}
