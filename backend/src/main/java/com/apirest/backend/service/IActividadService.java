package com.apirest.backend.service;

import java.util.List;
import java.util.Optional;

import com.apirest.backend.model.Actividad;

import Enums.estado;

public interface IActividadService {
    Actividad guardarActividad(Actividad actividad);
    List<Actividad> listarActividades();
    List<Actividad> filtrarPorEstado(estado estado);
    List<Actividad> filtrarPorCategoria(Integer idCategoria);
    Optional<Actividad> buscarActividadDetalle(Integer idActividad);
    Actividad actualizarActividad(Integer idActividad, Actividad actividad);
    String eliminarActividad(Integer idActividad);
}
