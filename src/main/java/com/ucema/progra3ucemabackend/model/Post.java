package com.ucema.progra3ucemabackend.model;

import jakarta.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "posts")

public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "texto")
    private String texto;

    @Column(name = "autor")
    private Usuario autor;

    @Column(name = "etiqueta")
    private Etiqueta etiqueta;

    @OneToMany(mappedBy = "posts")
    private List<Usuario> likes; //List of people who liked the post


    public Post(String texto, Usuario autor, Etiqueta etiqueta) {
        this.texto = texto;
        this.autor = autor;
        this.etiqueta = etiqueta;
        this.likes = new ArrayList<>();
    }

    public Post() {}

    //Getters & Setters

    public Long getId() { return id;}

    public Usuario getAutor() {
        return autor;
    }

    public String getTexto() {
        return texto;
    }
    public void setTexto(String newTexto) {
        this.texto = newTexto;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }
    public void setEtiqueta(Etiqueta newEtiqueta) {
        this.etiqueta = newEtiqueta;
    }

    public List<Usuario> getLikes() { return likes;}
    public void setLikes(List<Usuario> newLikes) { this.likes = newLikes; }

}






