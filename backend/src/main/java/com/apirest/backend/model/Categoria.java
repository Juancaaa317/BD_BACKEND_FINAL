package com.apirest.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Categoria {
    protected int idCategoria;
    protected String nombre;
    protected String descripcion;
}
