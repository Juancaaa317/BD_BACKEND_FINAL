package com.apirest.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.backend.model.Seguimiento;

public interface SeguimientoRepository extends JpaRepository<Seguimiento, Integer> {

    List<Seguimiento> findByIdUsuario_participante_IdUsuarioAndIdActividad_IdActividad(
            Integer idUsuario,
            Integer idActividad
    );

    List<Seguimiento> findByIdUsuario_instructor_IdUsuario(Integer idInstructor);
}
