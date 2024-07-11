package com.ucema.progra3ucemabackend.controllers;

import com.ucema.progra3ucemabackend.dto.LoginDTO;
import com.ucema.progra3ucemabackend.dto.ResponseLoginDTO;

import com.ucema.progra3ucemabackend.configuration.JwtUtilities;

import com.ucema.progra3ucemabackend.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {

    @Autowired
    private UsuarioService userService;

    @Autowired
    private JwtUtilities jwtUtilities;

    // POST ../api/auth/login
    @PostMapping(path = "/login")
    public ResponseLoginDTO authenticate(@RequestBody LoginDTO loginDTO) {
        return new ResponseLoginDTO(this.userService.authenticate(loginDTO.getUsername(), loginDTO.getPassword()));
    }

    // POST ../api/auth/logout
    @PostMapping("/logout")
    public void logout(@RequestHeader("Authorization") String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        jwtUtilities.invalidateToken(token);
    }

}
