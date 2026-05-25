package com.apirest.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apirest.backend.model.Seguimiento;
import com.apirest.backend.service.ISeguimientoService;

@RestController
@RequestMapping("/UAO/apirest/seguimiento")
public class SeguimientoController {

    @Autowired 
    ISeguimientoService seguimientoService;

    // Endpoint para crear un seguimiento
    @PostMapping("/")
    ResponseEntity<Seguimiento> crearSeguimiento(@RequestBody Seguimiento seguimiento) {
        return new ResponseEntity<Seguimiento>(
                seguimientoService.crearSeguimiento(seguimiento),
                HttpStatus.CREATED
        );
    }

    // Endpoint para consultar seguimientos de un participante en una actividad
    @GetMapping("/participante/{idUsuario}/actividad/{idActividad}")
    ResponseEntity<List<Seguimiento>> historialParticipanteActividad(
            @PathVariable Integer idUsuario,
            @PathVariable Integer idActividad) {

        return ResponseEntity.ok(
                seguimientoService.historialParticipanteActividad(idUsuario, idActividad)
        );
    }

    // Endpoint para consultar seguimientos realizados por un instructor
    @GetMapping("/instructor/{idInstructor}")
    ResponseEntity<List<Seguimiento>> seguimientosPorInstructor(@PathVariable Integer idInstructor) {
        return ResponseEntity.ok(
                seguimientoService.seguimientosPorInstructor(idInstructor)
        );
    }

    // Endpoint para actualizar un seguimiento
    @PutMapping("/{idSeguimiento}")
    ResponseEntity<Seguimiento> actualizarSeguimiento(
            @PathVariable Integer idSeguimiento,
            @RequestBody Seguimiento seguimiento) {

        return ResponseEntity.ok(
                seguimientoService.actualizarSeguimiento(idSeguimiento, seguimiento)
        );
    }

    // Endpoint para eliminar un seguimiento
    @DeleteMapping("/{idSeguimiento}")
    ResponseEntity<String> eliminarSeguimiento(@PathVariable Integer idSeguimiento) {
        return ResponseEntity.ok(
                seguimientoService.eliminarSeguimiento(idSeguimiento)
        );
    }
}