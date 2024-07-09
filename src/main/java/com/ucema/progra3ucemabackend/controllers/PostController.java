package com.ucema.progra3ucemabackend.controllers;

import com.ucema.progra3ucemabackend.model.Post;
import com.ucema.progra3ucemabackend.model.Etiqueta;
import com.ucema.progra3ucemabackend.model.Usuario;
import com.ucema.progra3ucemabackend.services.PostService;
import com.ucema.progra3ucemabackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/create")
    public Post crearPost(@RequestBody String texto, @RequestBody String username, @RequestBody Long etiquetaId) {
        Usuario usuario = usuarioService.getByUsername(username).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Etiqueta etiqueta = new Etiqueta();
        etiqueta.setId(etiquetaId);
        return postService.crearPost(texto, usuario, etiqueta);
    }

    @GetMapping("/user/{username}")
    public List<Post> obtenerPostsPorUsuario(@PathVariable String username) {
        Usuario usuario = usuarioService.getByUsername(username).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return postService.obtenerPostsPorUsuario(usuario);
    }

    @GetMapping("/etiqueta/{etiquetaId}")
    public List<Post> obtenerPostsPorEtiqueta(@PathVariable Long etiquetaId) {
        Etiqueta etiqueta = new Etiqueta(); // Suponiendo que tienes un método para obtener la etiqueta por ID
        etiqueta.setId(etiquetaId);
        return postService.obtenerPostsPorEtiqueta(etiqueta);
    }

    @GetMapping("/recientes")
    public List<Post> obtenerPostsRecientes() {
        return postService.obtenerPostsRecientes();
    }


}
