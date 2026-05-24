package com.apirest.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.model.Actividad;
import com.apirest.backend.repository.IActividadRepository;
import com.apirest.backend.repository.ICategoriaRepository;
import com.apirest.backend.repository.IUsuarioRepository;

import Enums.rol;

@Service
public class ActividadServiceImp implements IActividadService {

    @Autowired IActividadRepository actividadRepository;
    @Autowired IUsuarioRepository usuarioRepositoy;
    @Autowired ICategoriaRepository categoriaRepository;
    
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

    @Override
    public List<Actividad> listarActividades() {
        throw new UnsupportedOperationException("Unimplemented method 'listarActividades'");
    }
}
