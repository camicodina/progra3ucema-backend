package com.ucema.progra3ucemabackend.services;

import com.ucema.progra3ucemabackend.model.Etiqueta;
import java.util.List;
import java.util.Optional;

public interface EtiquetaService {

    Etiqueta crearEtiqueta(String nombre);

    Optional<Etiqueta> obtenerEtiquetaPorNombre(String nombre);
    Etiqueta obtenerEtiquetaPorId(Long id);

    List<Etiqueta> obtenerTodasLasEtiquetas();
}
