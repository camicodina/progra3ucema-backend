package com.ucema.progra3ucemabackend.controllers;

import com.ucema.progra3ucemabackend.model.Etiqueta;
import com.ucema.progra3ucemabackend.model.Usuario;
import com.ucema.progra3ucemabackend.model.Profesor;

import com.ucema.progra3ucemabackend.services.EtiquetaService;
import com.ucema.progra3ucemabackend.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etiquetas")

public class EtiquetaController {
    @Autowired
    private EtiquetaService etiquetaService;

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/create")
    public Etiqueta crearEtiqueta(@RequestParam String nombre, @RequestParam String username) {
        Usuario usuario = usuarioService.getByUsername(username).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!(usuario instanceof Profesor)) {
            throw new RuntimeException("Solo los profesores pueden crear etiquetas");
        }
        return etiquetaService.crearEtiqueta(nombre);
    }

    @GetMapping("/{id}")
    public Etiqueta obtenerEtiquetaPorId(@PathVariable Long id) {
        Etiqueta etiqueta = etiquetaService.obtenerEtiquetaPorId(id);
        if (etiqueta == null) { throw new RuntimeException("Etiqueta no encontrada"); }
        return etiqueta;
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
