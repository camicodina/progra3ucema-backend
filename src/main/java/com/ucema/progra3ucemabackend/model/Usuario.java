package com.ucema.progra3ucemabackend.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// JPA Entity for User
@Entity
@Table(name = "usuarios")

public abstract class Usuario {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(length = 100)
    private String email;


    public Usuario(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public Usuario() {}


    // Getters y Setters

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

    public String getUsername() {
        return username;
    }
    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String newPass) {
        this.password = newPass;
    }

    public abstract String getRole();

    public void setId(Long id) { this.id = id;}
    public Long getId() { return id; }

//    @ManyToMany
//    @JoinTable(
//            name = "seguidores",
//            joinColumns = @JoinColumn(name = "usuario_id"),
//            inverseJoinColumns = @JoinColumn(name = "seguidor_id")
//    )

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

    public Post crearPost(String texto, Etiqueta etiqueta) {
        Post nuevoPost = new Post(texto,this, etiqueta);
        postRepository.save(nuevoPost);
        return nuevoPost;
    }

    public Optional<Usuario> verOtroPerfil(String username) {
        // Retrieve user from database using Spring Data JPA
        return userRepository.findByUsuario(username); 
    }


}
