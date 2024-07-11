package com.ucema.progra3ucemabackend.controllers;

import com.ucema.progra3ucemabackend.model.Etiqueta;
import com.ucema.progra3ucemabackend.model.Usuario;

import com.ucema.progra3ucemabackend.services.EtiquetaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/etiquetas")
@CrossOrigin(origins = "*", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class EtiquetaController {
    @Autowired
    private EtiquetaService etiquetaService;


    // POST ../api/etiquetas
    @PostMapping("")
    public Etiqueta crearEtiqueta(@RequestParam String nombre, @RequestParam Usuario usuario) {
        if (usuario.getId() == null ) { throw new RuntimeException("Usuario no encontrado"); }
        try {
            return etiquetaService.crearEtiqueta(nombre, usuario);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Etiqueta obtenerEtiquetaPorId(@PathVariable Long id) {
        Etiqueta etiqueta = etiquetaService.obtenerEtiquetaPorId(id);
        if (etiqueta == null) { throw new RuntimeException("Etiqueta no encontrada"); }
        return etiqueta;
    }

    @GetMapping("")
    public List<Etiqueta> obtenerTodasLasEtiquetas() {
        return etiquetaService.obtenerTodasLasEtiquetas();
    }

    @GetMapping("/nombre/{nombre}")
    public Etiqueta obtenerEtiquetaPorNombre(@PathVariable String nombre) {
        return etiquetaService.obtenerEtiquetaPorNombre(nombre).orElseThrow(() -> new RuntimeException("Etiqueta no encontrada"));
    }

}
