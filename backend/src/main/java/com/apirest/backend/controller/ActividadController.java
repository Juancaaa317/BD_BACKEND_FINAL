package com.apirest.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend.model.Actividad;
import com.apirest.backend.service.IActividadService;

import Enums.estado;

@RequestMapping("/UAO/apirest/actividad") // endpoint
@RestController
public class ActividadController {
    @Autowired IActividadService actividadService;


   @PostMapping("/")
    ResponseEntity <Actividad> crearActividad(@RequestBody Actividad actividad){
        return new ResponseEntity<Actividad>(actividadService.guardarActividad(actividad),HttpStatus.CREATED);
    }
    
    @GetMapping("/")

    ResponseEntity<List<Actividad>> listarActividades(){
        return ResponseEntity.ok(actividadService.listarActividades());

    }

    @GetMapping("/estado/{estado}")
    ResponseEntity<List<Actividad>> filtrarPorEstado(@PathVariable Enums.estado estado){
        return ResponseEntity.ok(actividadService.filtrarPorEstado(estado));

    }
        
    

}
