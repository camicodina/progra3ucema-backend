package com.ucema.progra3ucemabackend.services;

import com.ucema.progra3ucemabackend.configuration.JwtUtilities;

import com.ucema.progra3ucemabackend.model.Alumno;
import com.ucema.progra3ucemabackend.model.Profesor;
import com.ucema.progra3ucemabackend.model.Usuario;
import com.ucema.progra3ucemabackend.model.Post;
import com.ucema.progra3ucemabackend.model.Etiqueta;

import com.ucema.progra3ucemabackend.repositories.UsuarioRepository;
import com.ucema.progra3ucemabackend.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtilities jwtUtilities;

    @Autowired
    private PostRepository postRepository;

    @Override
    @Transactional
    public Alumno createAlumno(Alumno alumno) {
        alumno.setPassword(passwordEncoder.encode(alumno.getPassword()));
        return usuarioRepository.save(alumno);
    }

    @Override
    @Transactional
    public Profesor createProfesor(Profesor profesor) {
        profesor.setPassword(passwordEncoder.encode(profesor.getPassword()));
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

    @Override
    public String authenticate(String username, String password) {
        Usuario user = this.usuarioRepository.findByUsername(username).orElse(null);
        if (user == null) {
            return null;
        }
        // Generar el token a retornar
        String token = jwtUtilities.generateToken(user.getUsername(), user.getId(), user.getRole());
        return token;

        // ACLARACION: Solo estoy retornando el JWT, el usuario no esta actualmente autenticado
        // por lo que si voy a realizar otra tarea debo generar el objeto correspondiente y
        // agregarlo al contexto de Spring

    }

    @Override
    public Usuario getUserInfo() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.usuarioRepository.findByUsername(username).orElse(null);
    }

    public Optional<Usuario> verOtroPerfil(String username) {
        return usuarioRepository.findByUsername(username);
    }

}

