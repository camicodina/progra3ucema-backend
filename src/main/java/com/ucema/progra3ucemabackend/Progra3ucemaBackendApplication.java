package com.ucema.progra3ucemabackend;

import com.ucema.progra3ucemabackend.model.Alumno;
import com.ucema.progra3ucemabackend.model.Profesor;
import com.ucema.progra3ucemabackend.model.Post;
import com.ucema.progra3ucemabackend.model.Etiqueta;

import com.ucema.progra3ucemabackend.services.PostService;
import com.ucema.progra3ucemabackend.services.UsuarioService;
import com.ucema.progra3ucemabackend.services.EtiquetaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Progra3ucemaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Progra3ucemaBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner init(@Autowired UsuarioService usuarioService,
						   @Autowired PostService postService,
						   @Autowired EtiquetaService etiquetaService) {
		return (args) -> {
			Alumno alumno1 = usuarioService.createAlumno(new Alumno("alumno1", "Javier", "alumno1@gmail.com", "1234", "Ingenieria", "1er año"));
			Alumno alumno2 = usuarioService.createAlumno(new Alumno("alumno2", "Isabella", "alumno2@gmail.com", "1234", "Economia", "2do año"));
			Profesor profesor1 = usuarioService.createProfesor(new Profesor("profesor1", "Carlos", "profesor1@gmail.com", "1234"));

			Etiqueta etiqueta1 = etiquetaService.crearEtiqueta("Spring");
			Etiqueta etiqueta2 = etiquetaService.crearEtiqueta("Java");
			Etiqueta etiqueta3 = etiquetaService.crearEtiqueta("Backend");

			Post post1 = postService.crearPost("Este es mi primer post sobre Spring!", alumno1, etiqueta1);
			Post post2 = postService.crearPost("Me encanta Java!", alumno2, etiqueta2);
			Post post3 = postService.crearPost("Aprendiendo sobre desarrollo backend", profesor1, etiqueta3);

			System.out.println("Progra3ucemaBackendApplication started");
		};
	}

}
