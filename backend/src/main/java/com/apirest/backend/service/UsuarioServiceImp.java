package com.apirest.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.model.Usuario;
import com.apirest.backend.repository.IUsuarioRepository;


@Service
public class UsuarioServiceImp implements IUsuarioService {
    @Autowired IUsuarioRepository usuarioRepository;
    @Override
    public Usuario guardaUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
}
