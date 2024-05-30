package com.ucema.progra3ucemabackend.services;

import com.ucema.progra3ucemabackend.model.Alumno;
import com.ucema.progra3ucemabackend.model.Profesor;
import com.ucema.progra3ucemabackend.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    Alumno createAlumno(String username, String name, String email, String password, String carrera, String año){
        Alumno alumno = new Alumno(username,name,email,password,carrera,año);
        return usuarioRepository.save(alumno);
    }

    @Override
    @Transactional
    Profesor createProfesor(String username, String name, String email, String password){
        Profesor profesor = new Profesor(username,name,email,password);
        return usuarioRepository.save(profesor);
    }

    @Override
    @Transactional
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public boolean deleteUsuario(Usuario usuario) {
        try {
            usuarioRepository.delete(usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> getByUsername(String username) {
        return this.usuarioRepository.findByUsername(username);
    }
}

