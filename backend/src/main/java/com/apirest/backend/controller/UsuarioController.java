package com.apirest.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend.model.Usuario;
import com.apirest.backend.service.IUsuarioService;

@RestController
@RequestMapping("/UAO/apirest/usuario")
public class UsuarioController {
    @Autowired IUsuarioService usuarioService;

    @PostMapping("/")//http:localhost:8080/UAO/apirest/usuario
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.guardaUsuario(usuario), HttpStatus.CREATED);
    }
    
}
