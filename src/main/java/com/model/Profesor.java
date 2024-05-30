package com.model;

import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

public class Profesor extends Usuario {

    public Profesor(String username, String name, String email, String password) {
        super(username, name, email, password);
    }

    public void BorrarPost(Post post){
        Optional<Post> postOptional = postRepository.findById(postId);

        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            if (post.getAutor().equals(this)) { // Check if the post belongs to this user
                postRepository.delete(post);
            } else {
                throw new IllegalArgumentException("No tienes permiso para borrar este post");
            }
        } else {
            throw new IllegalArgumentException("Post no encontrado");
        }
    }
}

