package com.apirest.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.model.Inscripcion;
import com.apirest.backend.model.Usuario;
import com.apirest.backend.repository.IActividadRepository;
import com.apirest.backend.repository.IInscripcionRepository;
import com.apirest.backend.repository.IUsuarioRepository;

@Service

public class InscripcionServiceImp implements IInscripcionService {

    @Autowired IUsuarioRepository usuarioRepository;
    @Autowired IActividadRepository actividadRepository;
    @Autowired IInscripcionRepository iInscripcionRepository;
    @Override

    
    public Inscripcion crearInscripcion(Inscripcion inscripcion) {
        Optional<Usuario> usuario = usuarioRepository.findById(inscripcion.getId().getIdUsuario().getIdUsuario());

        return inscripcion;
    }

    
}
