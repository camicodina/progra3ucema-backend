package com.ucema.progra3ucemabackend.controllers;

import com.ucema.progra3ucemabackend.dto.LoginDTO;
import com.ucema.progra3ucemabackend.dto.ResponseLoginDTO;

import com.ucema.progra3ucemabackend.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AuthController {

    @Autowired
    private UsuarioService userService;

    @PostMapping(path = "/login")
    public ResponseLoginDTO authenticate(@RequestBody LoginDTO loginDTO) {
        return new ResponseLoginDTO(this.userService.authenticate(loginDTO.getUsername(), loginDTO.getPassword()));
    }

}
