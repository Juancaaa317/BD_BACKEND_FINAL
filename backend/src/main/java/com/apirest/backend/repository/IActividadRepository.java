package com.apirest.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.apirest.backend.model.Actividad;

public interface IActividadRepository extends JpaRepository<Actividad, Integer>{
    
    List<Actividad> findByEstado(Enums.estado estado);
    @Query("SELECT a FROM Actividad a WHERE a.idCategoria.idCategoria = :idCategoria")
    List<Actividad> findByCategoria_IdCategoria(Integer idCategoria);
   

}
