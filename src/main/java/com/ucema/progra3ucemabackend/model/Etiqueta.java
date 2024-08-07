package com.ucema.progra3ucemabackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "etiquetas")
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etiqueta")
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String nombre;

    // Constructores

    public Etiqueta() {}

    public Etiqueta(String nombre) {
        this.nombre = nombre; 
    }


    // Getters y Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

}
