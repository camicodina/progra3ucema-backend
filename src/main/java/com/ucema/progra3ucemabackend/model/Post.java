package com.ucema.progra3ucemabackend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private Long id;

    @Column(nullable = false)
    private String texto;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "etiqueta_id", nullable = true) // Hace la etiqueta opcional
    private Etiqueta etiqueta;

    @Column(name = "likes")
    private int likes;


    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion = new Date();


    public Post(String texto, Usuario usuario, Etiqueta etiqueta) {
        this.texto = texto;
        this.usuario = usuario;
        this.etiqueta = etiqueta;
        this.fechaCreacion = new Date();
        this.likes = 0;
    }

    public Post() {}

    //Getters & Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public Etiqueta getEtiqueta() { return etiqueta;}
    public void setEtiqueta(Etiqueta etiqueta) { this.etiqueta = etiqueta; }

    public int getLikes() { return likes; }
    public void setLikes(int likes) { this.likes = likes; }


    // Métodos para manejar likes y etiquetas

    public void incrementarLikes() { this.likes++; }

    public void decrementarLikes() {
        if (this.likes > 0) { this.likes--; }
    }


}






