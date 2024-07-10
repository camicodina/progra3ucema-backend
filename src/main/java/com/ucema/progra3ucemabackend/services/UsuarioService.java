package com.ucema.progra3ucemabackend.services;

import com.ucema.progra3ucemabackend.model.*;

import java.util.Optional;

public interface UsuarioService {
    
    Alumno crearAlumno(Alumno alumno);
    Profesor crearProfesor(Profesor profesor);

    Usuario updateUsuario(Usuario usuario);

    boolean deleteUsuario(Usuario usuario);

    Optional<Usuario> getByUsername(String username);
    Optional<Usuario> obtenerUsuarioPorId(Long id);

    String authenticate(String username, String password);

    Usuario getUserInfo();

    Optional<Usuario> verOtroPerfil(String username);

    void follow(Long IdSeguidor, Long IdSeguido);
}
