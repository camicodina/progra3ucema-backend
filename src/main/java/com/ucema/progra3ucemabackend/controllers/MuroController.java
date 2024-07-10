package com.ucema.progra3ucemabackend.controllers;

import com.ucema.progra3ucemabackend.model.Post;
import com.ucema.progra3ucemabackend.model.Usuario;

import com.ucema.progra3ucemabackend.services.MuroService;
import com.ucema.progra3ucemabackend.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/muro")
public class MuroController {

    @Autowired
    private MuroService muroService;

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return muroService.mostrarPosts();
    }

    @GetMapping("/perfil/{username}")
    public Usuario getPerfil(@PathVariable String username) {
        Usuario usuario = usuarioService.getByUsername(username).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return muroService.mostrarPerfil(usuario);
    }

    @GetMapping("/posts/{username}")
    public List<Post> getPostsByUsuario(@PathVariable String username) {
        Usuario usuario = usuarioService.getByUsername(username).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return muroService.mostrarPostsDelUsuario(usuario);
    }

    @PostMapping("/logout")
    public void logout(@RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        muroService.logout(token);
    }
}
