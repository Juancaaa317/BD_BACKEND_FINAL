package com.apirest.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.model.Actividad;
import com.apirest.backend.model.Inscripcion;
import com.apirest.backend.model.Usuario;
import com.apirest.backend.repository.IActividadRepository;
import com.apirest.backend.repository.IInscripcionRepository;
import com.apirest.backend.repository.IUsuarioRepository;

import Enums.estado;
import Enums.estadoInscripcion;
import Enums.rol;

@Service
public class InscripcionServiceImp implements IInscripcionService {

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    IActividadRepository actividadRepository;

    @Autowired
    IInscripcionRepository iInscripcionRepository;

    @Override
    public Inscripcion crearInscripcion(Inscripcion inscripcion) {
        
        Usuario usuario = usuarioRepository.findById(inscripcion.getId().getIdUsuario().getIdUsuario())
        .orElseThrow(() ->new RuntimeException("Usuario no encontrado"));

        // Validar rol
        if (usuario.getRol() != rol.participante) {
            throw new RuntimeException("Solo participantes pueden inscribirse");
        }
        
        //validar actividad
        Actividad actividad = actividadRepository.findById(inscripcion.getId().getIdActividad().getIdActividad())
        .orElseThrow(() ->new RuntimeException("actividad no encontrada"));

        //cupos maximos
        int inscritos = iInscripcionRepository.countById_IdActividad_IdActividad(actividad.getIdActividad());

        if(inscritos >= actividad.getCupo_maximo()){
            throw new RuntimeException("no hay cupo papi");
        }

        //set fecha automatico
        inscripcion.setFecha_inscripcion(new Date()); 
        //set estado inscrito
        inscripcion.setEstado(estadoInscripcion.inscrito);


        if (actividad.getEstado() == estado.finalizada || actividad.getEstado() == estado.cancelada) {
            throw new RuntimeException("No se puede inscribir en actividades finalizads");
        }



        return iInscripcionRepository.save(inscripcion);
    }

    //listar por estado
    @Override
    public List<Inscripcion> listarPorEstado(estadoInscripcion estado) {
        return iInscripcionRepository.findByEstado(estado);
        
    }


    //buscar inscripcion
    @Override
    public Inscripcion buscarInscripcion(Integer idUsuario, Integer idActividad) {
        return iInscripcionRepository.findById_IdUsuario_IdUsuarioAndId_IdActividad_IdActividad(idUsuario, idActividad).orElseThrow(()
        -> new RuntimeException("Error! No se encontró la inscripción."));
    }
        
        
    //actualizarEstado
    @Override
    public Inscripcion actualizarEstado(Integer idUsuario, Integer idActividad, estadoInscripcion nuevoEstado) {
        
        Inscripcion inscripcion= buscarInscripcion( idUsuario,idActividad);
        inscripcion.setEstado(nuevoEstado);
        return iInscripcionRepository.save(inscripcion);
    }

    
    
    

    




}