package com.ucema.progra3ucemabackend.services;

import com.ucema.progra3ucemabackend.model.Alumno;
import com.ucema.progra3ucemabackend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Alumno getAlumnoById(Long id) {
        return (Alumno) usuarioRepository.findById(id).orElse(null);
    }
}
