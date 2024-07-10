package com.ucema.progra3ucemabackend;

import com.ucema.progra3ucemabackend.model.Alumno;
import com.ucema.progra3ucemabackend.model.Profesor;
import com.ucema.progra3ucemabackend.model.Etiqueta;
import com.ucema.progra3ucemabackend.model.Post;

import com.ucema.progra3ucemabackend.services.EtiquetaService;
import com.ucema.progra3ucemabackend.services.PostService;
import com.ucema.progra3ucemabackend.services.UsuarioService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Test
	void init(){
	}

	/*
	 Test para probar el funcionamiento de los métodos de UsuarioService y PostService.
	 UsuarioService, PostService y EtiquetaService son inyectadas y podemos probarlas.
	 Test de ejemplo de como utilizarlas.
	 */

//	@Test
//	void createAndGetEntitiesTest() {
//
//		// Crear y verificar Alumnos
//		Alumno alumno1 = usuarioService.crearAlumno(new Alumno("alumno1", "Javier", "alumno1@gmail.com", "1234", "Ingenieria", "1er año"));
//		Assert.notNull(alumno1.getId(), "No se ha asignado un id al alumno1");
//
//		Alumno alumno2 = usuarioService.crearAlumno(new Alumno("alumno2", "Isabella", "alumno2@gmail.com", "1234", "Economia", "2do año"));
//		Assert.notNull(alumno2.getId(), "No se ha asignado un id al alumno2");
//
//		// Crear y verificar Profesor
//		Profesor profesor1 = usuarioService.crearProfesor(new Profesor("profesor1", "Carlos", "profesor1@gmail.com", "1234"));
//		Assert.notNull(profesor1.getId(), "No se ha asignado un id al profesor1");
//
//		// Crear y verificar Etiquetas
//		Etiqueta etiqueta1 = etiquetaService.crearEtiqueta("Spring");
//		Assert.notNull(etiqueta1.getId(), "No se ha asignado un id a la etiqueta1");
//
//		Etiqueta etiqueta2 = etiquetaService.crearEtiqueta("Java");
//		Assert.notNull(etiqueta2.getId(), "No se ha asignado un id a la etiqueta2");
//
//		// Crear y verificar Posts
//		Post post1 = postService.crearPost("Este es mi primer post sobre Spring!", alumno1, etiqueta1);
//		Assert.notNull(post1.getId(), "No se ha asignado un id al post1");
//
//		Post post2 = postService.crearPost("Me encanta Java!", alumno2, etiqueta2);
//		Assert.notNull(post2.getId(), "No se ha asignado un id al post2");
//
//
//		List<Post> posts = postService.obtenerPostsRecientes();
//		Assert.isTrue(posts.size() >= 2, "No se han obtenido los posts correctamente");
//
//		Post retrievedPost1 = posts.stream().filter(post -> Objects.equals(post.getId(), post1.getId())).findFirst().orElse(null);
//		Assert.notNull(retrievedPost1, "No se ha encontrado el post1 en la lista de posts recientes");
//
//		Post retrievedPost2 = posts.stream().filter(post -> Objects.equals(post.getId(), post2.getId())).findFirst().orElse(null);
//		Assert.notNull(retrievedPost2, "No se ha encontrado el post2 en la lista de posts recientes");
//
//	}

}
