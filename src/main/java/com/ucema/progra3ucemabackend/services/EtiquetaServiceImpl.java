package com.ucema.progra3ucemabackend.services;

import com.ucema.progra3ucemabackend.model.Etiqueta;
import com.ucema.progra3ucemabackend.repositories.EtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class EtiquetaServiceImpl implements EtiquetaService {

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Override
    public Etiqueta crearEtiqueta(String nombre) {
        Etiqueta etiqueta = new Etiqueta(nombre);
        return etiquetaRepository.save(etiqueta);
    }

    @Override
    public Optional<Etiqueta> obtenerEtiquetaPorId(Long id) {
        return etiquetaRepository.findById(id);
    }

    @Override
    public List<Etiqueta> obtenerTodasLasEtiquetas() {
        return etiquetaRepository.findAll();
    }

    @Override
    public Optional<Etiqueta> obtenerEtiquetaPorNombre(String nombre) {
        return etiquetaRepository.findByNombre(nombre);
    }

    @Override
    public List<Etiqueta> obtenerEtiquetasPorIds(List<Long> ids) {
        return etiquetaRepository.findAllById(ids);
    }

}
