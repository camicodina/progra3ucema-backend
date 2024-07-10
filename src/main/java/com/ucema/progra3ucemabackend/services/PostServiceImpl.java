package com.ucema.progra3ucemabackend.services;

import com.ucema.progra3ucemabackend.model.Post;
import com.ucema.progra3ucemabackend.model.Etiqueta;
import com.ucema.progra3ucemabackend.model.Usuario;

import com.ucema.progra3ucemabackend.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post crearPost(String texto, Usuario usuario, Etiqueta etiqueta) {
        Post nuevoPost = new Post(texto, usuario, etiqueta);
        return postRepository.save(nuevoPost);
    }

    @Override
    public void borrarPost(Post post, Usuario borrador) {
        if (borrador.getId() == null) { throw new RuntimeException("Usuario no encontrado"); }

        if (!"PROFESOR".equals(borrador.getRole())) {
            throw new RuntimeException("Solo los profesores pueden borrar posts");
        }
        postRepository.delete(post);
    }

    @Override
    public void darLike(Post post) {
        post.incrementarLikes();
        postRepository.save(post);
    }

    @Override
    public void quitarLike(Post post) {
        post.decrementarLikes();
        postRepository.save(post);
    }

    @Override
    public List<Post> obtenerPostsPorUsuario(Usuario usuario) {
        return postRepository.findByUsuario(usuario);
    }

    @Override
    public List<Post> obtenerPostsPorEtiqueta(Etiqueta etiqueta) {
        return postRepository.findByEtiqueta(etiqueta);
    }

    @Override
    public List<Post> obtenerPostsRecientes() {
        return postRepository.findTop30ByOrderByFechaCreacionDesc();
    }

    @Override
    public Optional<Post> obtenerPostPorId(Long id) {
        return postRepository.findById(id);
    }

}
