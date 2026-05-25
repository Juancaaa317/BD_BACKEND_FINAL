package com.apirest.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apirest.backend.model.Seguimiento;

public interface ISeguimientoRepository extends  JpaRepository<Seguimiento, Integer> {

    @Query("SELECT COUNT(s) > 0 FROM Seguimiento s WHERE s.idUsuario_participante.idUsuario = :idUsuario AND s.idActividad.idActividad = :idActividad")
    boolean existsByUsuarioAndActividad(@Param("idUsuario") Integer idUsuario, @Param("idActividad") Integer idActividad); 
}
