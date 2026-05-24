package com.apirest.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend.model.Actividad;
import com.apirest.backend.service.IActividadService;

@RequestMapping("/UAO/apirest/publicacion") // endpoint
@RestController
public class ActividadController {
    @Autowired IActividadService actividadService;


   @PostMapping("/")
    ResponseEntity <Actividad> crearActividad(@RequestBody Actividad actividad){
        return new ResponseEntity<Actividad>(actividadService.guardarActividad(actividad),HttpStatus.CREATED);
    }

}
