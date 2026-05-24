package com.apirest.backend.service;

import java.util.List;

import com.apirest.backend.model.Actividad;

public interface IActividadService {
    Actividad guardarActividad(Actividad actividad);
    List<Actividad> listarActividades();
}
