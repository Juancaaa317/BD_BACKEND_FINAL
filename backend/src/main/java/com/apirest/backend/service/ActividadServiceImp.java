package com.apirest.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.model.Actividad;
import com.apirest.backend.repository.IActividadRepository;
import com.apirest.backend.repository.IUsuarioRepository;

@Service
public class ActividadServiceImp implements IActividadService {

    @Autowired IActividadRepository actividadRepository;
    @Autowired IUsuarioRepository usuarioRepositoy;

    
    public Actividad guardarActividad(Actividad actividad){
        
        if (!usuarioRepositoy.existsById(actividad.getIdUsuario_propone().getIdUsuario())) {
            throw new RuntimeException("Error! El usuario que propone no existe.");
        }
        return actividadRepository.save(actividad);

    }

    @Override
    public List<Actividad> listarActividades() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarActividades'");
    }
}
