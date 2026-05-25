package com.apirest.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.apirest.backend.model.Inscripcion;
import com.apirest.backend.model.InscripcionId;

public interface IInscripcionRepository extends JpaRepository<Inscripcion, InscripcionId>  {
    
    int countById_IdActividad_IdActividad(Integer idActividad);
    
    List<Inscripcion>findByEstado(Enums.estadoInscripcion estado);

    Inscripcion buscarPorUsuarioYActividad(Integer idUsuario, Integer idActividad);

    Optional<Inscripcion>findById_IdUsuario_IdUsuarioAndId_IdActividad_IdActividad(Integer idUsuario,Integer idActividad);

    List<Inscripcion> findById_IdActividad_IdActividad(Integer idActividad);

}
