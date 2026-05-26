package com.apirest.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apirest.backend.model.Inscripcion;
import com.apirest.backend.model.InscripcionId;

import Enums.estadoInscripcion;

public interface IInscripcionRepository extends JpaRepository<Inscripcion, InscripcionId>  {
    
    @Query("SELECT COUNT(i) FROM Inscripcion i WHERE i.id.idActividad.idActividad = :idActividad")
    int countById_IdActividad_IdActividad(@Param("idActividad") Integer idActividad);

    List<Inscripcion> findByEstado(estadoInscripcion estado);

    @Query("SELECT i FROM Inscripcion i WHERE i.id.idUsuario.idUsuario = :idUsuario AND i.id.idActividad.idActividad = :idActividad")
    Optional<Inscripcion> findById_IdUsuario_IdUsuarioAndId_IdActividad_IdActividad(
        @Param("idUsuario") Integer idUsuario,
        @Param("idActividad") Integer idActividad
    );

    @Query("SELECT i FROM Inscripcion i WHERE i.id.idActividad.idActividad = :idActividad")
    List<Inscripcion> findById_IdActividad_IdActividad(@Param("idActividad") Integer idActividad);

    @Query("SELECT COUNT(i) > 0 FROM Inscripcion i WHERE i.id.idActividad.idActividad = :idActividad")
    boolean existsByIdActividad(@Param("idActividad") Integer idActividad);

    
}