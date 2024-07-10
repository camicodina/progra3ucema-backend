package com.ucema.progra3ucemabackend.model;


public class Muro {

    private String id;
    private Usuario usuario;


// Constructores

    public Muro() {}

    public Muro(String id, Usuario usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    // Getters y Setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

}
