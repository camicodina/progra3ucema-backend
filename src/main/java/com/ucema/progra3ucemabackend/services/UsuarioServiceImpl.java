package com.ucema.progra3ucemabackend.services;

import com.ucema.progra3ucemabackend.configuration.JwtUtilities;

import com.ucema.progra3ucemabackend.model.Alumno;
import com.ucema.progra3ucemabackend.model.Profesor;
import com.ucema.progra3ucemabackend.model.Usuario;

import com.ucema.progra3ucemabackend.repositories.UsuarioRepository;

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


    @Override
    @Transactional
    public Alumno crearAlumno(Alumno alumno) {
        alumno.setPassword(passwordEncoder.encode(alumno.getPassword()));
        return usuarioRepository.save(alumno);
    }

    @Override
    @Transactional
    public Profesor crearProfesor(Profesor profesor) {
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
    @Transactional(readOnly = true)
    public Optional<Usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }


    @Override
    public String authenticate(String username, String password) {
        Usuario user = this.usuarioRepository.findByUsername(username).orElse(null);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            return null;
        }

        // Generar el token a retornar
        String token = jwtUtilities.generateToken(user.getUsername(), user.getId(), user.getRole());
        return token;
    }

    @Override
    public Usuario getUserInfo() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.usuarioRepository.findByUsername(username).orElse(null);
    }

    public Optional<Usuario> verOtroPerfil(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public void follow(Long IdUser, Long IdSeguido) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(IdUser);
        Optional<Usuario> seguidoOptional = usuarioRepository.findById(IdSeguido);

        if (usuarioOptional.isPresent() && seguidoOptional.isPresent()) {
            Usuario seguidor = usuarioOptional.get();
            Usuario seguido = seguidoOptional.get();

            if (!seguidor.getSiguiendo().contains(seguido)) {
                seguidor.getSiguiendo().add(seguido);
                seguido.getSeguidores().add(seguidor);

                usuarioRepository.save(seguidor);
                usuarioRepository.save(seguido);
            }

        } else { throw new RuntimeException("Usuario no encontrado"); }
    }

}

