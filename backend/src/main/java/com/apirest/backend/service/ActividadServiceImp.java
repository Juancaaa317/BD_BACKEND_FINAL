package com.apirest.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.model.Actividad;
import com.apirest.backend.repository.IActividadRepository;
import com.apirest.backend.repository.ICategoriaRepository;
import com.apirest.backend.repository.IUsuarioRepository;

import Enums.estado;
import Enums.rol;

@Service
public class ActividadServiceImp implements IActividadService {

    @Autowired IActividadRepository actividadRepository;
    @Autowired IUsuarioRepository usuarioRepositoy;
    @Autowired ICategoriaRepository categoriaRepository;

    //crear act
    public Actividad guardarActividad(Actividad actividad){
        
        if (!usuarioRepositoy.existsById(actividad.getIdUsuario_propone().getIdUsuario())) {
            throw new RuntimeException("Error! El usuario que propone no existe.");
        }
        
        
        rol rolUsuario = actividad.getIdUsuario_propone().getRol();
        if (rolUsuario==rol.participante) {
            throw new RuntimeException("Error! Un participante no puede proponer actividades.");
        }

        if (!categoriaRepository.existsById(actividad.getIdCategoria().getIdCategoria())) {
            throw new RuntimeException("Error! La categoría no existe.");
        }

        return actividadRepository.save(actividad);

    }

    //listar
    @Override
    public List<Actividad> listarActividades() {
        return actividadRepository.findAll();
    }
    //filtrar por estado
    @Override
    public List<Actividad> filtrarPorEstado(estado estado) {
        return actividadRepository.findByEstado(estado);
    }
    //filtrar por categoria
    @Override
    public List<Actividad> filtrarPorCategoria(Integer idCategoria) {
        return actividadRepository.filtrarPorCategoria(idCategoria);
        
    
    }
    //filtrar detalle
    @Override
    public Optional<Actividad> buscarActividadDetalle(Integer idActividad) {
        if(!actividadRepository.existsById(idActividad)){
            throw new RuntimeException("Error! La categoría no existe.");
        }
        return actividadRepository.findById(idActividad);
    }
    //actualizar
    @Override
    public Actividad actualizarActividad(Integer idActividad, Actividad actividad) {
        if (!actividadRepository.existsById(idActividad)) {
            throw new RuntimeException("Error! La actividad no existe.");
        }
        Actividad actividadExistente = actividadRepository.findById(idActividad).get();
 
        actividadExistente.setNombre(actividad.getNombre());
        actividadExistente.setDescripcion(actividad.getDescripcion());
        actividadExistente.setEstado(actividad.getEstado());    
 
        return actividadRepository.save(actividadExistente);
    }
    //eliminar

    @Override
    public String eliminarActividad(Integer idActividad) {
        
        if(!actividadRepository.existsById(idActividad)){
            throw new RuntimeException("Error! La actividad no existe.");
        }

        boolean tieneInscritos = actividadRepository.tieneInscritos(idActividad);
        boolean tieneSesiones  = actividadRepository.tieneSesiones(idActividad);

        if (tieneInscritos || tieneSesiones) {
            Actividad actividad = actividadRepository.findById(idActividad).get();
            actividad.setEstado(estado.cancelada);
            actividadRepository.save(actividad);

            return "La actividad tiene relaciones asociadas. Se realizó borrado lógico.";
        }
        // Borrado físico
        actividadRepository.deleteById(idActividad);
        return "Actividad eliminada correctamente";
    
        
       
        
    }
    
    
    




}
