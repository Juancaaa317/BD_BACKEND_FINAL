package com.apirest.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.model.Categoria;
import com.apirest.backend.repository.ICategoriaRepository;


@Service
public class CategoriaServiceImp implements ICategoriaService {


    @Autowired ICategoriaRepository categoriaRepository;
    @Override
    public Categoria guardaCategoria(Categoria categoria) {
        
        return categoriaRepository.save(categoria);
        
    }
    
}
