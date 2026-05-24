package com.apirest.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.backend.model.Actividad;

public interface IActividadRepository extends JpaRepository<Actividad, Integer>{
    
}
