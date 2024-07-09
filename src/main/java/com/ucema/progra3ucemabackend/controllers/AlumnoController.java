package com.ucema.progra3ucemabackend.controllers;

import com.ucema.progra3ucemabackend.model.Alumno;
import com.ucema.progra3ucemabackend.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/{id}")
    public Alumno getAlumnoById(@PathVariable Long id) {
        return alumnoService.getAlumnoById(id);
    }
}
