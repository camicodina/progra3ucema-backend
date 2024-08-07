package com.ucema.progra3ucemabackend.services;

import com.ucema.progra3ucemabackend.model.Etiqueta;
import com.ucema.progra3ucemabackend.model.Usuario;

import com.ucema.progra3ucemabackend.repositories.EtiquetaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtiquetaServiceImpl implements EtiquetaService {

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Override
    public Etiqueta crearEtiqueta(String nombre, Usuario usuario) {
        if (!"PROFESOR".equals(usuario.getRole())) {
            throw new RuntimeException("Solo los profesores pueden crear etiquetas");
        }

        // Verificar si ya existe una etiqueta con el mismo nombre
        Optional<Etiqueta> etiquetaExistente = etiquetaRepository.findByNombre(nombre);
        if (etiquetaExistente.isPresent()) {
            throw new RuntimeException("Ya existe una etiqueta con este nombre");
        }

        Etiqueta etiqueta = new Etiqueta(nombre);
        return etiquetaRepository.save(etiqueta);
    }

    @Override
    public Etiqueta obtenerEtiquetaPorId(Long id) {
        return etiquetaRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Etiqueta> obtenerEtiquetaPorNombre(String nombre) {
        return etiquetaRepository.findByNombre(nombre);
    }

    @Override
    public List<Etiqueta> obtenerTodasLasEtiquetas() {
        return etiquetaRepository.findAll();
    }

}
