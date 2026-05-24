package com.apirest.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.apirest.backend.model.Actividad;

public interface IActividadRepository extends JpaRepository<Actividad, Integer>{
    
    List<Actividad> findByEstado(Enums.estado estado);
    List<Actividad> filtrarPorCategoria(Integer idCategoria);
    boolean tieneSesiones(Integer idActividad);
    boolean tieneInscritos( Integer idActividad);
}
