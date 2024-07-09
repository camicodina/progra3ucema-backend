package com.ucema.progra3ucemabackend.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private Long id;

    @Column(name = "texto", nullable = false)
    private String texto;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario autor;

    @ManyToMany
    @JoinTable(
            name = "post_etiqueta",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    private List<Etiqueta> etiquetas = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "post_likes",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> likes = new ArrayList<>();

    @Column(name = "fecha_creacion", nullable = false)

    private Date fechaCreacion = new Date();


    public Post(String texto, Usuario autor, List<Etiqueta> etiquetas) {
        this.texto = texto;
        this.autor = autor;
        this.etiquetas = etiquetas;
        this.fechaCreacion = new Date();
        this.likes = new ArrayList<>();
    }

    public Post() {}

    //Getters & Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getAutor() { return autor; }
    public void setAutor(Usuario autor) { this.autor = autor; }

    public String getTexto() {
        return texto;
    }
    public void setTexto(String newTexto) {
        this.texto = newTexto;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }
    public void setEtiquetas(List<Etiqueta> etiquetas) { this.etiquetas = etiquetas; }

    public List<Usuario> getLikes() { return likes; }
    public void setLikes(List<Usuario> likes) { this.likes = likes; }

    public Date getFechaCreacion() { return fechaCreacion; }

    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    // Métodos para manejar likes y etiquetas

    public void addLike(Usuario usuario) {
        this.likes.add(usuario);
    }

    public void removeLike(Usuario usuario) {
        this.likes.remove(usuario);
    }

    public void addEtiqueta(Etiqueta etiqueta) {
        this.etiquetas.add(etiqueta);
        etiqueta.getPosts().add(this);
    }

    public void removeEtiqueta(Etiqueta etiqueta) {
        this.etiquetas.remove(etiqueta);
        etiqueta.getPosts().remove(this);
    }

}






