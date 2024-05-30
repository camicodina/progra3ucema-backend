package com.ucema.progra3ucemabackend.model;

public class Alumno extends Usuario {
    private String carrera;
    private String año;

    public Alumno(String username, String name, String email, String password, String carrera, String año) {
        super(username, name, email, password);
        this.carrera = carrera;
        this.año = año;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
}
