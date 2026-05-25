package com.apirest.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apirest.backend.model.Inscripcion;
import com.apirest.backend.service.IInscripcionService;


@RequestMapping("/UAO/apirest/inscripcion") // endpoint
@RestController
public class InscripcionController {
    @Autowired IInscripcionService inscripcionService;

    @PostMapping("/")
    ResponseEntity <Inscripcion> crearInscripcion(@RequestBody Inscripcion inscripcion){
        return new ResponseEntity<Inscripcion>(inscripcionService.crearInscripcion(inscripcion),HttpStatus.CREATED);
    }
    
}
