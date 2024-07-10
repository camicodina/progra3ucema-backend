package com.ucema.progra3ucemabackend.services;

import com.ucema.progra3ucemabackend.configuration.JwtUtilities;

import com.ucema.progra3ucemabackend.model.Post;
import com.ucema.progra3ucemabackend.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuroServiceImpl implements MuroService {

    @Autowired
    private PostService postService;

    @Autowired
    private JwtUtilities jwtUtilities;

    @Override
    public List<Post> mostrarPosts() {
        List<Post> posts = postService.obtenerPostsRecientes();
        posts.sort((p1, p2) -> p2.getFechaCreacion().compareTo(p1.getFechaCreacion()));
        return posts;
    }

    @Override
    public Usuario mostrarPerfil(Usuario usuario) {
        return usuario;
    }

    @Override
    public List<Post> mostrarPostsDelUsuario(Usuario usuario) {
        List<Post> posts = postService.obtenerPostsPorUsuario(usuario);
        posts.sort((p1, p2) -> p2.getFechaCreacion().compareTo(p1.getFechaCreacion()));
        return posts;
    }

    @Override
    public void logout(String token) {
        jwtUtilities.invalidateToken(token);  // Invalidar el token
    }

}
