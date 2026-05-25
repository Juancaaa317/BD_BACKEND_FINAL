package com.apirest.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apirest.backend.model.Sesion;

@Repository
public interface ISesionRepository extends JpaRepository<Sesion, Integer> {

    @Query("SELECT COUNT(s) > 0 FROM Sesion s WHERE s.idActividad.idActividad = :idActividad")
    boolean existsByIdActividad(@Param("idActividad") Integer idActividad);

}