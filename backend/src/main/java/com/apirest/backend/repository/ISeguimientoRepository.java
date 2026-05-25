package com.apirest.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apirest.backend.model.Seguimiento;

public interface ISeguimientoRepository extends JpaRepository<Seguimiento, Integer> {

    // Buscar seguimientos de un participante en una actividad
    @Query("SELECT s FROM Seguimiento s WHERE s.idUsuario_participante.idUsuario = :idUsuario AND s.idActividad.idActividad = :idActividad")
    List<Seguimiento> buscarHistorialParticipanteActividad(
            @Param("idUsuario") Integer idUsuario,
            @Param("idActividad") Integer idActividad
    );

    // Buscar seguimientos realizados por un instructor
    @Query("SELECT s FROM Seguimiento s WHERE s.idUsuario_instructor.idUsuario = :idInstructor")
    List<Seguimiento> buscarSeguimientosPorInstructor(
            @Param("idInstructor") Integer idInstructor
    );
}