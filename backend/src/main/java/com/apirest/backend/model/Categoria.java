package com.apirest.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="categoria")
public class Categoria {
    @Id
    protected int idCategoria;
    protected String nombre;
    protected String descripcion;
}
