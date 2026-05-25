package com.apirest.backend.service;

import java.util.List;

import com.apirest.backend.model.Seguimiento;

public interface ISeguimientoService {

    Seguimiento crearSeguimiento(Seguimiento seguimiento);

    List<Seguimiento> historialParticipanteActividad(Integer idUsuario, Integer idActividad);

    List<Seguimiento> seguimientosPorInstructor(Integer idInstructor);

    Seguimiento actualizarSeguimiento(Integer idSeguimiento, Seguimiento seguimiento);

    String eliminarSeguimiento(Integer idSeguimiento);
}