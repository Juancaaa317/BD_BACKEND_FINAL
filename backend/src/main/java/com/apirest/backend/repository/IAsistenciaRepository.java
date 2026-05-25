package com.apirest.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apirest.backend.model.Asistencia;

public interface IAsistenciaRepository extends JpaRepository<Asistencia, Integer> {

    @Query("SELECT COUNT(a) > 0 FROM Asistencia a " +
           "WHERE a.idUsuario.idUsuario = :idUsuario " +
           "AND a.idSesion.idActividad.idActividad = :idActividad")
    boolean existePorUsuarioYActividad(
        @Param("idUsuario") Integer idUsuario,
        @Param("idActividad") Integer idActividad
    );
}