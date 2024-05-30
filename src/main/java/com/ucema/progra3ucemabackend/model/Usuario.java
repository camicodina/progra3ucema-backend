package com.ucema.progra3ucemabackend.model;

import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

// JPA Entity for User
@Entity
@Table(name = "usuarios")

public abstract class Usuario {

    private String username;
    private String name;
    private String email;
    private String password;

    public Usuario(String username, String name, String email, String password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters y Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPass(String newPass) {
        this.password = newPass;
    }


    @ManyToMany
    @JoinTable(
            name = "seguidores",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "seguidor_id")
    )

    private List<Usuario> siguiendo; // List of users this user is following

    @ManyToMany(mappedBy = "siguiendo")
    private List<Usuario> seguidores; // List of users following this user

    

    @Autowired
    private PostRepository postRepository;

        public void follow(Usuario usuarioASeguir) {
            if (!siguiendo.contains(usuarioASeguir)) {
                siguiendo.add(usuarioASeguir);
                usuarioASeguir.seguidores.add(this);
            }
        }

    public Post crearPost(String texto) {
        Post nuevoPost = new Post(texto, this); 
        postRepository.save(nuevoPost);
        return nuevoPost;
    }

    public Optional<Usuario> verOtroPerfil(String username) {
        // Retrieve user from database using Spring Data JPA
        return userRepository.findByUsuario(username); 
    }

   

    // Other methods 
    public boolean ingresar() {
        // Logic to validate and log in
    }

  

}
