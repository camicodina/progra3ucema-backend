package com.ucema.progra3ucemabackend.services;

import com.ucema.progra3ucemabackend.model.Post;
import com.ucema.progra3ucemabackend.model.Usuario;

import java.util.List;

public interface MuroService {

    List<Post> mostrarPosts();
    Usuario mostrarPerfil(Usuario usuario);
    List<Post> mostrarPostsDelUsuario(Usuario usuario);

    void logout(String token);
}
