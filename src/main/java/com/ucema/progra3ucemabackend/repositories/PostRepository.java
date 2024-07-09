package com.ucema.progra3ucemabackend.repositories;

import com.ucema.progra3ucemabackend.model.Post;
import com.ucema.progra3ucemabackend.model.Etiqueta;
import com.ucema.progra3ucemabackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUsuario(Usuario usuario);

    List<Post> findByEtiqueta(Etiqueta etiqueta);

    List<Post> findTop30ByOrderByFechaCreacionDesc();


}
