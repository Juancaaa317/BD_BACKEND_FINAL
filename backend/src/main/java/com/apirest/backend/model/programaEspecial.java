package com.apirest.backend.model;


import java.util.Date;

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
@Table(name="programaespecial")

public class programaEspecial {
    @Id
    protected int idPrograma;
    protected String nombre;
    protected String descripcion;
    protected Date fecha_inicio;
    protected Date fecha_fin;
    protected String poblacion_objetivo;
    protected Enums.tipo tipo;
}
