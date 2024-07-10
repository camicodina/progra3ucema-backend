package com.ucema.progra3ucemabackend.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// JPA Entity for User
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Usuario implements UserDetails {

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

    @ManyToMany
    @JoinTable(
            name = "seguidores",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "seguidor_id")
    )
    private List<Usuario> siguiendo = new ArrayList<>();

    @ManyToMany(mappedBy = "siguiendo")

    private List<Usuario> seguidores = new ArrayList<>();

    // Constructores

    public Usuario(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public Usuario() {}


    // Getters y Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id;}

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

    public List<Usuario> getSiguiendo() { return siguiendo; }
    public void setSiguiendo(List<Usuario> siguiendo) { this.siguiendo = siguiendo; }

    public List<Usuario> getSeguidores() { return seguidores; }
    public void setSeguidores(List<Usuario> seguidores) { this.seguidores = seguidores; }

    public abstract String getRole();


    // Implementación de UserDetails

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(getRole()));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
