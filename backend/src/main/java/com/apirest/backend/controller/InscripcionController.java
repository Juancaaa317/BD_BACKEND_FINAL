package com.apirest.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.apirest.backend.model.Inscripcion;
import com.apirest.backend.service.IInscripcionService;

import Enums.estadoInscripcion;


@RequestMapping("/UAO/apirest/inscripcion") // endpoint
@RestController
public class InscripcionController {

    @Autowired IInscripcionService inscripcionService;
    //creacion
    @PostMapping("/")
    ResponseEntity <Inscripcion> crearInscripcion(@RequestBody Inscripcion inscripcion){
        return new ResponseEntity<Inscripcion>(inscripcionService.crearInscripcion(inscripcion),HttpStatus.CREATED);
    }
    
    //filtrar estado

    @GetMapping("/estado/{estado}")
    ResponseEntity<List<Inscripcion>>listarPorEstado(@PathVariable estadoInscripcion estado){
        return ResponseEntity.ok(inscripcionService.listarPorEstado(estado));
        
    }
    
    //filtrar actividad inscritas by id
    @GetMapping("/actividad/{idActividad}")
    ResponseEntity<List<Inscripcion>>listarPorActividad(@PathVariable Integer idActividad){
        return ResponseEntity.ok(inscripcionService.listarPorActividad(idActividad));

    }

    //Mostrar los datos básicos del usuario y el estado de su inscripción.

    @GetMapping("/usuario/{idUsuario}/actividad/{idActividad}")
    ResponseEntity<Inscripcion> buscar(@PathVariable Integer idUsuario,@PathVariable Integer idActividad){
        return ResponseEntity.ok(inscripcionService.buscarInscripcion(idUsuario, idActividad));
    }
    
    //actualizar

    @PutMapping("/usuario/{idUsuario}/actividad/{idActividad}/estado/{estado}")
     ResponseEntity<Inscripcion> actualizarEstado(@PathVariable Integer idUsuario,@PathVariable Integer idActividad, @PathVariable estadoInscripcion estado){
        return ResponseEntity.ok(inscripcionService.actualizarEstado(idUsuario, idActividad, estado));
    }
    //eliminar

    @DeleteMapping("/usuario/{idUsuario}/actividad/{idActividad}")
    ResponseEntity<String>eliminarInscripcion(@PathVariable Integer idUsuario,@PathVariable Integer idActividad){
        return ResponseEntity.ok(inscripcionService.eliminarInscripcion(idUsuario, idActividad));
    }

    








}
