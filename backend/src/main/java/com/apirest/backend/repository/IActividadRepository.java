package com.apirest.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apirest.backend.model.Actividad;

public interface IActividadRepository extends JpaRepository<Actividad, Integer>{
    
    List<Actividad> findByEstado(Enums.estado estado);
    @Query("SELECT a FROM Actividad a WHERE a.idCategoria.idCategoria = :idCategoria")
    List<Actividad> findByCategoria_IdCategoria(Integer idCategoria);
    @Query("SELECT COUNT(s) > 0 FROM Sesion s WHERE s.idActividad.idActividad = :idActividad")
    boolean tieneSesiones(@Param("idActividad") Integer idActividad);

    @Query("SELECT COUNT(i) > 0 FROM Inscripcion i WHERE i.id.idActividad.idActividad = :idActividad")
    boolean tieneInscritos(@Param("idActividad") Integer idActividad);

    @Query("SELECT a FROM Actividad a WHERE a.idCategoria.idCategoria = :idCategoria")
    List<Actividad> filtrarPorCategoria(@Param("idCategoria") Integer idCategoria);
}
