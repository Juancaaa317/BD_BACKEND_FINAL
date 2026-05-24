package com.apirest.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Actividad")
public class Actividad {
    protected int idActividad;
    protected Categoria idCategoria;
    protected Usuario idUsuario;
    protected Usuario idUsuario_propone;
    protected Usuario idUsuario_aprueba;
    protected Usuario idUsuario_imparte;
    protected String nombre;
    protected String descripcion;
    protected String objetivo;
    protected Date fecha_inicio;
    protected Date fecha_finalizacion;
    protected int intensidad_horaria;
    protected int cupo_maximo;
    protected Enums.estado estado;
}
 //se debe mapear como esta en la tabla