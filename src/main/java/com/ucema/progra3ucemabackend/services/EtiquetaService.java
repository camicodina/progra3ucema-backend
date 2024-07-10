package com.ucema.progra3ucemabackend.services;

import com.ucema.progra3ucemabackend.model.Etiqueta;
import com.ucema.progra3ucemabackend.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface EtiquetaService {

    Etiqueta crearEtiqueta(String nombre, Usuario usuario);

    Optional<Etiqueta> obtenerEtiquetaPorNombre(String nombre);
    Etiqueta obtenerEtiquetaPorId(Long id);

    List<Etiqueta> obtenerTodasLasEtiquetas();
}
