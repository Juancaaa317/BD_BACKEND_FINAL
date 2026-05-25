package com.apirest.backend.service;

import java.util.List;

import com.apirest.backend.model.Inscripcion;

import Enums.estadoInscripcion;

public interface IInscripcionService {
    Inscripcion crearInscripcion(Inscripcion inscripcion);
    List<Inscripcion>listarPorEstado(Enums.estadoInscripcion estado);
    Inscripcion actualizarEstado(Integer idUsuario, Integer idActividad, estadoInscripcion nuevoEstado);
    Inscripcion buscarInscripcion(Integer idUsuario,Integer idActividad);
    String eliminarInscripcion(Integer idUsuario, Integer idActividad);
    List<Inscripcion> listarPorActividad(Integer idActividad);



    
}
