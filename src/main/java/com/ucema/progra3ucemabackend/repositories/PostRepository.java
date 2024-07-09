package com.ucema.progra3ucemabackend.repositories;

import com.ucema.progra3ucemabackend.model.Post;
import com.ucema.progra3ucemabackend.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUsuario(Usuario usuario);

    List<Post> findByEtiqueta(Etiqueta etiqueta);

    List<Post> findTop10ByOrderByFechaCreacionDesc();


}
