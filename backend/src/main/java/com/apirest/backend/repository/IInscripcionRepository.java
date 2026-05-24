package com.apirest.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.backend.model.Inscripcion;
import com.apirest.backend.model.InscripcionId;

public interface IInscripcionRepository extends JpaRepository<Inscripcion, InscripcionId>  {
    
}
