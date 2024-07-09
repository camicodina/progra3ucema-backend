package com.ucema.progra3ucemabackend.controllers;

import com.ucema.progra3ucemabackend.model.Alumno;
import com.ucema.progra3ucemabackend.model.Profesor;
import com.ucema.progra3ucemabackend.model.Usuario;

import com.ucema.progra3ucemabackend.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/usuario")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // POST ../api/usuario/alumno
    @PostMapping(value = "/alumno")
    public Usuario createAlumno(@RequestBody Alumno usuario) {
        return usuarioService.createAlumno(usuario);
    }

    // POST ../api/usuario/profesor
    @PostMapping(value = "/profesor")
    public Usuario createProfesor(@RequestBody Profesor usuario) {
        return usuarioService.createProfesor(usuario);
    }

    // PUT ../api/usuario
    @PutMapping(value = "/update")
    public Usuario updateUsuario(@RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(usuario);
    }

    // DELETE ../api/usuario
    @DeleteMapping(value = "/delete")
    public boolean deleteUsuario(@RequestBody Usuario usuario) {
        return usuarioService.deleteUsuario(usuario);
    }

    // GET ../api/usuario/username/{username}
    @GetMapping(value = "username/{username}")
    public Usuario getByUsername(@PathVariable String username) {
        return usuarioService.getByUsername(username).orElse(null);
    }

    // GET ../api/usuario/{id}
    @GetMapping("/{id}")
    public Optional<Usuario> getById(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        return usuarioService.authenticate(username, password);
    }

    /**
     * Endpoint para obtener la información del usuario logueado mediante jwt
     */

    @GetMapping(value = "/info")
    public Usuario getUserInfo() {
        return usuarioService.getUserInfo();
    }

    @GetMapping("/verPerfil/{username}")
    public Optional<Usuario> verOtroPerfil(@PathVariable String username) {
        return usuarioService.verOtroPerfil(username);
    }
}
