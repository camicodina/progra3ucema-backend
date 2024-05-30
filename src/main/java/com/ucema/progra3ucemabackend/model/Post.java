package com.ucema.progra3ucemabackend.model;

public class Post {
    String id;
    String texto;
    Usuario autor;
    Etiqueta etiqueta;
    List<Persona> like; // List of people who liked the post

    public Post(String id, String texto, Usuario autor, Etiqueta etiqueta) {
        this.id = id;
        this.texto = texto;
        this.autor = autor;
        this.etiqueta = etiqueta;
        this.like = new ArrayList<>();
}
