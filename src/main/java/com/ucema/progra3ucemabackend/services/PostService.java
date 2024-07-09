package com.ucema.progra3ucemabackend.services;

import com.ucema.progra3ucemabackend.model.Usuario;
import com.ucema.progra3ucemabackend.model.Post;
import com.ucema.progra3ucemabackend.model.Etiqueta;

import java.util.List;
import java.util.Optional;

public interface PostService {

    Post crearPost(String texto, Usuario usuario, Etiqueta etiqueta);
    void borrarPost(Post post);

    List<Post> obtenerPostsPorUsuario(Usuario usuario);
    List<Post> obtenerPostsPorEtiqueta(Etiqueta etiqueta);
    List<Post> obtenerPostsRecientes();
    Optional<Post> obtenerPostPorId(Long id);
}
