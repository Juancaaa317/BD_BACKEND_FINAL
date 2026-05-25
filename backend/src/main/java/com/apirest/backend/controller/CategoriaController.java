package com.apirest.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend.model.Categoria;
import com.apirest.backend.service.ICategoriaService;


@RestController
@RequestMapping("/UAO/apirest/categoria")
public class CategoriaController {
    @Autowired ICategoriaService categoriaService ;

    @PostMapping("/")//http:localhost:8080/UAO/apirest/usuario
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria){
        return new ResponseEntity<>(categoriaService.guardaCategoria(categoria), HttpStatus.CREATED);

    }



}
