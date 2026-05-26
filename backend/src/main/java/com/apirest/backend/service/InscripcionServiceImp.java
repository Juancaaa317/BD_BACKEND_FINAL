package com.apirest.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.model.Actividad;
import com.apirest.backend.model.Inscripcion;
import com.apirest.backend.model.Usuario;
import com.apirest.backend.repository.IActividadRepository;
import com.apirest.backend.repository.IAsistenciaRepository;
import com.apirest.backend.repository.IInscripcionRepository;
import com.apirest.backend.repository.ISeguimientoRepository;
import com.apirest.backend.repository.ISesionRepository;
import com.apirest.backend.repository.IUsuarioRepository;

import Enums.estado;
import Enums.estadoInscripcion;
import Enums.rol;

@Service
public class InscripcionServiceImp implements IInscripcionService {

    @Autowired
    IUsuarioRepository usuarioRepository;
    @Autowired
    ISesionRepository sesionRepository;
    @Autowired IAsistenciaRepository asistenciaRepository;
    @Autowired
    IActividadRepository actividadRepository;

    @Autowired
    IInscripcionRepository iInscripcionRepository;

    @Autowired ISeguimientoRepository seguimientoRepository;
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
            throw new RuntimeException("No hay cupo ");
        }

        //set fecha automatico
        inscripcion.setFechaInscripcion(new Date()); 
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

    //listar actividad
    @Override
    public List<Inscripcion> listarPorActividad(Integer idActividad) {

        if (!actividadRepository.existsById(idActividad)) {
            throw new RuntimeException("Error! La actividad no existe.");
        }
        return iInscripcionRepository.findById_IdActividad_IdActividad(idActividad);
    }



    //buscar inscripcion, Mostrar los datos básicos del usuario y el estado de su inscripción.

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

    //eliminar
    @Override
    public String eliminarInscripcion(Integer idUsuario, Integer idActividad) {
        
        Inscripcion inscripcion =buscarInscripcion( idUsuario,idActividad);
        
         boolean tieneSeguimientos = !seguimientoRepository
        .buscarHistorialParticipanteActividad(idUsuario, idActividad).isEmpty();

    boolean tieneAsistencias = asistenciaRepository
        .existePorUsuarioYActividad(idUsuario, idActividad);

    // BORRADO LÓGICO — tiene historial
    if (tieneSeguimientos || tieneAsistencias) {
        inscripcion.setEstado(Enums.estadoInscripcion.retirado);
        iInscripcionRepository.save(inscripcion);
        return "El participante tiene historial registrado. Estado cambiado a 'retirado'.";
    }

    // BORRADO FÍSICO — sin historial
    iInscripcionRepository.delete(inscripcion);
    return "Inscripción eliminada correctamente.";
}

 
    

    
    

    
    
    

    




}