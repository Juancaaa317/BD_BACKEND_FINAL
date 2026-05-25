package com.apirest.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.model.Actividad;
import com.apirest.backend.model.Inscripcion;
import com.apirest.backend.model.Seguimiento;
import com.apirest.backend.model.Usuario;
import com.apirest.backend.repository.IActividadRepository;
import com.apirest.backend.repository.IInscripcionRepository;
import com.apirest.backend.repository.IUsuarioRepository;
import com.apirest.backend.repository.ISeguimientoRepository;

import Enums.estado;
import Enums.estadoInscripcion;
import Enums.rol;

@Service
public class SeguimientoServiceImp implements ISeguimientoService {

    @Autowired
    ISeguimientoRepository seguimientoRepository;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    IActividadRepository actividadRepository;

    @Autowired
    IInscripcionRepository inscripcionRepository;

    // Método para crear un seguimiento
    @Override
    public Seguimiento crearSeguimiento(Seguimiento seguimiento) {

        // Valida que se envíe un ID válido
        if (seguimiento.getIdSeguimiento() <= 0) {
            throw new RuntimeException("Error! Debe enviar un idSeguimiento válido.");
        }

        // Valida que el seguimiento no exista previamente
        if (seguimientoRepository.existsById(seguimiento.getIdSeguimiento())) {
            throw new RuntimeException("Error! Ya existe un seguimiento con ese idSeguimiento.");
        }

        // Valida que se envíe la actividad
        if (seguimiento.getIdActividad() == null) {
            throw new RuntimeException("Error! Debe enviar la actividad.");
        }

        // Valida que se envíe el instructor
        if (seguimiento.getIdUsuario_instructor() == null) {
            throw new RuntimeException("Error! Debe enviar el instructor.");
        }

        // Valida que se envíe el participante
        if (seguimiento.getIdUsuario_participante() == null) {
            throw new RuntimeException("Error! Debe enviar el participante.");
        }

        // Obtiene los IDs enviados desde Postman
        Integer idActividad = seguimiento.getIdActividad().getIdActividad();
        Integer idInstructor = seguimiento.getIdUsuario_instructor().getIdUsuario();
        Integer idParticipante = seguimiento.getIdUsuario_participante().getIdUsuario();

        // Busca la actividad en la base de datos
        Actividad actividad = actividadRepository.findById(idActividad)
                .orElseThrow(() -> new RuntimeException("Error! La actividad no existe."));

        // Busca el usuario instructor en la base de datos
        Usuario instructor = usuarioRepository.findById(idInstructor)
                .orElseThrow(() -> new RuntimeException("Error! El instructor no existe."));

        // Busca el usuario participante en la base de datos
        Usuario participante = usuarioRepository.findById(idParticipante)
                .orElseThrow(() -> new RuntimeException("Error! El participante no existe."));

        // Valida que el evaluador sea instructor
        if (instructor.getRol() != rol.instructor) {
            throw new RuntimeException("Error! El evaluador debe tener rol de instructor.");
        }

        // Valida que el evaluado sea participante
        if (participante.getRol() != rol.participante) {
            throw new RuntimeException("Error! El evaluado debe tener rol de participante.");
        }

        // Valida que la actividad no esté finalizada o cancelada
        if (actividad.getEstado() == estado.finalizada || actividad.getEstado() == estado.cancelada) {
            throw new RuntimeException("Error! No se pueden hacer seguimientos en actividades finalizadas o canceladas.");
        }

        // Busca la inscripción del participante en la actividad
        Inscripcion inscripcion = inscripcionRepository
                .findById_IdUsuario_IdUsuarioAndId_IdActividad_IdActividad(idParticipante, idActividad)
                .orElseThrow(() -> new RuntimeException("Error! El participante no está inscrito en esta actividad."));

        // Valida que la inscripción esté en estado matriculado
        if (inscripcion.getEstado() != estadoInscripcion.matriculado) {
            throw new RuntimeException("Error! El participante debe estar matriculado en la actividad.");
        }

        // Asigna los objetos completos encontrados en la base de datos
        seguimiento.setIdActividad(actividad);
        seguimiento.setIdUsuario_instructor(instructor);
        seguimiento.setIdUsuario_participante(participante);

        // Asigna la fecha actual si no se envía desde Postman
        if (seguimiento.getFecha_registro() == null) {
            seguimiento.setFecha_registro(new Date());
        }

        // Guarda el seguimiento
        return seguimientoRepository.save(seguimiento);
    }

    // Método para consultar el historial de un participante en una actividad
    @Override
    public List<Seguimiento> historialParticipanteActividad(Integer idUsuario, Integer idActividad) {

        // Valida que el participante exista
        if (!usuarioRepository.existsById(idUsuario)) {
            throw new RuntimeException("Error! El participante no existe.");
        }

        // Valida que la actividad exista
        if (!actividadRepository.existsById(idActividad)) {
            throw new RuntimeException("Error! La actividad no existe.");
        }

        // Retorna los seguimientos encontrados
        return seguimientoRepository
                .findByIdUsuario_participante_IdUsuarioAndIdActividad_IdActividad(idUsuario, idActividad);
    }

    // Método para consultar seguimientos realizados por un instructor
    @Override
    public List<Seguimiento> seguimientosPorInstructor(Integer idInstructor) {

        // Busca el instructor en la base de datos
        Usuario instructor = usuarioRepository.findById(idInstructor)
                .orElseThrow(() -> new RuntimeException("Error! El instructor no existe."));

        // Valida que el usuario sea instructor
        if (instructor.getRol() != rol.instructor) {
            throw new RuntimeException("Error! El usuario consultado no tiene rol de instructor.");
        }

        // Retorna los seguimientos realizados por el instructor
        return seguimientoRepository.findByIdUsuario_instructor_IdUsuario(idInstructor);
    }

    // Método para actualizar un seguimiento
    @Override
    public Seguimiento actualizarSeguimiento(Integer idSeguimiento, Seguimiento seguimiento) {

        // Busca el seguimiento existente
        Seguimiento seguimientoExistente = seguimientoRepository.findById(idSeguimiento)
                .orElseThrow(() -> new RuntimeException("Error! El seguimiento no existe."));

        // Actualiza los campos permitidos
        seguimientoExistente.setComentario(seguimiento.getComentario());
        seguimientoExistente.setAspecto_evaluado(seguimiento.getAspecto_evaluado());
        seguimientoExistente.setNivel_progreso(seguimiento.getNivel_progreso());
        seguimientoExistente.setObservaciones(seguimiento.getObservaciones());

        // Guarda los cambios
        return seguimientoRepository.save(seguimientoExistente);
    }

    // Método para eliminar un seguimiento
    @Override
    public String eliminarSeguimiento(Integer idSeguimiento) {

        // Valida que el seguimiento exista
        if (!seguimientoRepository.existsById(idSeguimiento)) {
            throw new RuntimeException("Error! El seguimiento no existe.");
        }

        // Elimina el seguimiento
        seguimientoRepository.deleteById(idSeguimiento);

        return "Seguimiento eliminado correctamente.";
    }
}