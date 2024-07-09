package com.ucema.progra3ucemabackend.model;

import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Entity
public class Profesor extends Usuario {

    public Profesor(String username, String name, String email, String password) {
        super(username, name, email, password);
    }


    public void BorrarPost(Post postId){
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


    @Override
    public String getRole() {
        return "PROFESOR";
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("PROFESOR"));
//        return authorities;
//    }

}

