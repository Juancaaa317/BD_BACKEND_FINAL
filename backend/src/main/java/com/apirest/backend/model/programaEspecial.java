package com.apirest.backend.model;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class programaEspecial {
    protected int idPrograma;
    protected String nombre;
    protected String descripcion;
    protected Date fecha_inicio;
    protected Date fecha_fin;
    protected String poblacion_objetivo;
    protected Enums.tipo tipo;
}
