package com.ucema.progra3ucemabackend.controllers;

import com.ucema.progra3ucemabackend.model.Post;
import com.ucema.progra3ucemabackend.model.Etiqueta;
import com.ucema.progra3ucemabackend.model.Usuario;

import com.ucema.progra3ucemabackend.services.PostService;
import com.ucema.progra3ucemabackend.services.UsuarioService;
import com.ucema.progra3ucemabackend.services.EtiquetaService;

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

    @Autowired
    private EtiquetaService etiquetaService;

    // POST ../api/posts
    @PostMapping("")
    public Post crearPost(@RequestParam String texto, @RequestParam String username, @RequestParam(required = false) Long etiquetaId) {
        Usuario usuario = usuarioService.getByUsername(username).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Etiqueta etiqueta = etiquetaId != null ? etiquetaService.obtenerEtiquetaPorId(etiquetaId) : null;
        return postService.crearPost(texto, usuario, etiqueta);
    }

    @DeleteMapping("/{postId}")
    public void borrarPost(@PathVariable Long postId) {
        Post post = postService.obtenerPostPorId(postId).orElseThrow(() -> new RuntimeException("Post no encontrado"));
        Usuario usuario = post.getUsuario();
        if (usuario == null) { throw new RuntimeException("Usuario no encontrado"); }

        if (!"PROFESOR".equals(usuario.getRole())) {
            throw new RuntimeException("Solo los profesores pueden borrar posts");
        }
        postService.borrarPost(post);
    }


    @GetMapping("/user/{username}")
    public List<Post> obtenerPostsPorUsuario(@PathVariable String username) {
        Usuario usuario = usuarioService.getByUsername(username).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return postService.obtenerPostsPorUsuario(usuario);
    }

    @GetMapping("/etiqueta/{etiquetaId}")
    public List<Post> obtenerPostsPorEtiqueta(@PathVariable Long etiquetaId) {
        Etiqueta etiqueta = etiquetaService.obtenerEtiquetaPorId(etiquetaId);
        return postService.obtenerPostsPorEtiqueta(etiqueta);
    }

    @GetMapping("/recientes")
    public List<Post> obtenerPostsRecientes() {
        return postService.obtenerPostsRecientes();
    }

    @PostMapping("/{id}/like")
    public void darLike(@PathVariable Long id) {
        Post post = postService.obtenerPostPorId(id).orElseThrow(() -> new RuntimeException("Post no encontrado"));
        postService.darLike(post);
    }

    @PostMapping("/{id}/unlike")
    public void quitarLike(@PathVariable Long id) {
        Post post = postService.obtenerPostPorId(id).orElseThrow(() -> new RuntimeException("Post no encontrado"));
        postService.quitarLike(post);
    }

}
