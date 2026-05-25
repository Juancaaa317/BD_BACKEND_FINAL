package com.apirest.backend.service;

import java.util.List;

import com.apirest.backend.model.Inscripcion;

public interface IInscripcionService {
    Inscripcion crearInscripcion(Inscripcion inscripcion);
    List<Inscripcion>listarPorEstado(Enums.estadoInscripcion estado);
}
