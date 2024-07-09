package com.ucema.progra3ucemabackend.controllers;

import com.ucema.progra3ucemabackend.model.Etiqueta;
import com.ucema.progra3ucemabackend.services.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etiquetas")

public class EtiquetaController {
    @Autowired
    private EtiquetaService etiquetaService;

    @PostMapping("/create")
    public Etiqueta crearEtiqueta(@RequestBody String nombre) {
        return etiquetaService.crearEtiqueta(nombre);
    }

    @GetMapping("/{id}")
    public Etiqueta obtenerEtiquetaPorId(@PathVariable Long id) {
        return etiquetaService.obtenerEtiquetaPorId(id).orElseThrow(() -> new RuntimeException("Etiqueta no encontrada"));
    }

    @GetMapping("/todas")
    public List<Etiqueta> obtenerTodasLasEtiquetas() {
        return etiquetaService.obtenerTodasLasEtiquetas();
    }

    @GetMapping("/nombre/{nombre}")
    public Etiqueta obtenerEtiquetaPorNombre(@PathVariable String nombre) {
        return etiquetaService.obtenerEtiquetaPorNombre(nombre).orElseThrow(() -> new RuntimeException("Etiqueta no encontrada"));
    }

}
