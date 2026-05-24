package com.apirest.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.backend.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
