package com.apirest.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "actividad")
public class Actividad {
    @Id
    protected Integer idActividad;
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    protected Categoria idCategoria;
    @ManyToOne
    @JoinColumn(name = "idUsuario_propone")
    protected Usuario idUsuario_propone;
    @ManyToOne
    @JoinColumn(name = "idUsuario_aprueba")
    protected Usuario idUsuario_aprueba;
    @ManyToOne
    @JoinColumn(name = "idUsuario_imparte")
    protected Usuario idUsuario_imparte;
    @ManyToOne
    @JoinColumn(name = "idPrograma")
    protected programaEspecial idPrograma;
    protected String nombre;
    protected String descripcion;
    protected String objetivo;
    protected Date fecha_inicio;
    protected Date fecha_finalizacion;
    protected Integer intensidad_horaria;
    protected Integer cupo_maximo;
    
    @Enumerated(EnumType.STRING)
    protected Enums.estado estado;
}
 //se debe mapear como esta en la tabla