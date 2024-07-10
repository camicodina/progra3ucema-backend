package com.ucema.progra3ucemabackend;

import com.ucema.progra3ucemabackend.model.Alumno;
import com.ucema.progra3ucemabackend.model.Etiqueta;
import com.ucema.progra3ucemabackend.model.Post;
import com.ucema.progra3ucemabackend.model.Profesor;

import com.ucema.progra3ucemabackend.services.EtiquetaService;
import com.ucema.progra3ucemabackend.services.PostService;
import com.ucema.progra3ucemabackend.services.UsuarioService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

@SpringBootTest
class Progra3ucemaBackendApplicationTests {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PostService postService;

	@Autowired
	private EtiquetaService etiquetaService;

	@Test
	void contextLoads() {
	}

	/*
	 Test para probar el funcionamiento de los métodos de UsuarioService y PostService.
	 UsuarioService, PostService y EtiquetaService son inyectadas y podemos probarlas.
	 Test de ejemplo de como utilizarlas.
	 */

	@Test
	void createAndGetEntitiesTest() {

		// Crear y verificar Alumnos
		Alumno alumno3 = usuarioService.crearAlumno(new Alumno("alumno3", "Sofia", "alumno3@gmail.com", "5678", "Arquitectura", "3er año"));
		Assert.notNull(alumno3.getId(), "No se ha asignado un id al alumno3");

		Alumno alumno4 = usuarioService.crearAlumno(new Alumno("alumno4", "Mateo", "alumno4@gmail.com", "5678", "Medicina", "4to año"));
		Assert.notNull(alumno4.getId(), "No se ha asignado un id al alumno4");

		// Crear y verificar Profesor
		Profesor profesor2 = usuarioService.crearProfesor(new Profesor("profesor2", "Ana", "profesor2@gmail.com", "5678"));
		Assert.notNull(profesor2.getId(), "No se ha asignado un id al profesor2");

		// Crear y verificar Etiquetas
		Etiqueta etiqueta4 = etiquetaService.crearEtiqueta("React", profesor2);
		Assert.notNull(etiqueta4.getId(), "No se ha asignado un id a la etiqueta4");

		Etiqueta etiqueta5 = etiquetaService.crearEtiqueta("Python", profesor2);
		Assert.notNull(etiqueta5.getId(), "No se ha asignado un id a la etiqueta5");

		// Crear y verificar Posts
		Post post3 = postService.crearPost("Alguno me puede dar una mano con React? Es para un TP", alumno3, etiqueta4);
		Assert.notNull(post3.getId(), "No se ha asignado un id al post3");

		Post post4 = postService.crearPost("Python es superior, prove me wrong", alumno4, etiqueta5);
		Assert.notNull(post4.getId(), "No se ha asignado un id al post4");

		List<Post> posts = postService.obtenerPostsRecientes();
		Assert.isTrue(posts.size() >= 2, "No se han obtenido los posts correctamente");

		Post retrievedPost3 = posts.stream().filter(post -> Objects.equals(post.getId(), post3.getId())).findFirst().orElse(null);
		Assert.notNull(retrievedPost3, "No se ha encontrado el post3 en la lista de posts recientes");

		Post retrievedPost4 = posts.stream().filter(post -> Objects.equals(post.getId(), post4.getId())).findFirst().orElse(null);
		Assert.notNull(retrievedPost4, "No se ha encontrado el post4 en la lista de posts recientes");

	}

}
