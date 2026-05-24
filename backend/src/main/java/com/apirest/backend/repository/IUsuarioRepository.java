package com.apirest.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.backend.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
