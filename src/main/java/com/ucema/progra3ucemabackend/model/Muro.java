package com.ucema.progra3ucemabackend.model;

import com.ucema.progra3ucemabackend.configuration.JwtUtilities;

import com.ucema.progra3ucemabackend.services.PostService;
import com.ucema.progra3ucemabackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class Muro {

    private String id;
    private Usuario usuario;

    @Autowired
    private PostService postService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtilities jwtUtilities;


    public Muro() {}

    public Muro(String id, Usuario usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public List<Post> mostrarPosts() {
       List<Post> posts = postService.obtenerPostsRecientes();
       posts.sort((p1, p2) -> p2.getFechaCreacion().compareTo(p1.getFechaCreacion()));
        return posts;
    }

    public Usuario mostrarPerfil() {
        return usuario;
    }

    public List<Post> mostrarPostsDelUsuario() {
        List<Post> posts = postService.obtenerPostsPorUsuario(usuario);
        posts.sort((p1, p2) -> p2.getFechaCreacion().compareTo(p1.getFechaCreacion()));
        return posts;
    }

    public void logout(String token) {
        jwtUtilities.invalidateToken(token);  // Invalidar el token
    }

    // Getters y Setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public void setPostService(PostService postService) { this.postService = postService; }
    public void setUsuarioService(UsuarioService usuarioService) { this.usuarioService = usuarioService; }
}
