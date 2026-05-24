package com.apirest.backend.controller;

import java.util.List;
import java.util.Optional;

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

import com.apirest.backend.model.Actividad;
import com.apirest.backend.service.IActividadService;

import Enums.estado;

@RequestMapping("/UAO/apirest/actividad") // endpoint
@RestController
public class ActividadController {
    @Autowired IActividadService actividadService;

    //crear
   @PostMapping("/")
    ResponseEntity <Actividad> crearActividad(@RequestBody Actividad actividad){
        return new ResponseEntity<Actividad>(actividadService.guardarActividad(actividad),HttpStatus.CREATED);
    }
    
    @GetMapping("/")
    //listar
    ResponseEntity<List<Actividad>> listarActividades(){
        return ResponseEntity.ok(actividadService.listarActividades());

    }
    //filtrar por estado
    @GetMapping("/estado/{estado}")
    ResponseEntity<List<Actividad>> filtrarPorEstado(@PathVariable estado estado){
        return ResponseEntity.ok(actividadService.filtrarPorEstado(estado));

    }
    //filtrar por categoria
    @GetMapping("/estado/{idCategoria}")
    ResponseEntity<List<Actividad>> filtrarPorCategoria(@PathVariable Integer idCategoria){
        return ResponseEntity.ok(actividadService.filtrarPorCategoria(idCategoria));
    }
    //buscar detalle
    @GetMapping("{id}")
    public ResponseEntity<Optional<Actividad>> buscarActividadDetalle(@PathVariable Integer idActividad){
        return ResponseEntity.ok(actividadService.buscarActividadDetalle(idActividad));
    }
    //actualizar
    @PutMapping("/{idActividad}")
    Actividad actualizarActividad(@PathVariable Integer idActividad, @RequestBody Actividad actividad){
        return actividadService.actualizarActividad(idActividad, actividad);
    }
    //eliminar
    @DeleteMapping("/{id}")
    ResponseEntity<String> eliminarActividad(@PathVariable Integer idActividad){
        return ResponseEntity.ok(actividadService.eliminarActividad(idActividad));
    }




}
