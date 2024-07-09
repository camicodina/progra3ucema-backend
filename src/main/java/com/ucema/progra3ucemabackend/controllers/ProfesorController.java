package com.ucema.progra3ucemabackend.controllers;

import com.ucema.progra3ucemabackend.model.Etiqueta;
import com.ucema.progra3ucemabackend.model.Post;
import com.ucema.progra3ucemabackend.model.Profesor;

import com.ucema.progra3ucemabackend.services.EtiquetaService;
import com.ucema.progra3ucemabackend.services.PostService;
import com.ucema.progra3ucemabackend.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private PostService postService;

    @Autowired
    private EtiquetaService etiquetaService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/etiquetas")
    public Etiqueta crearEtiqueta(@RequestBody String nombre) {
        return etiquetaService.crearEtiqueta(nombre);
    }

    @DeleteMapping("/posts/{postId}")
    public void borrarPost(@PathVariable Long postId) {
        Post post = postService.obtenerPostPorId(postId).orElseThrow(() -> new RuntimeException("Post no encontrado"));
        postService.borrarPost(post);
    }
}
