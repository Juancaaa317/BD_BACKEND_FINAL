package com.apirest.backend.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seguimiento")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Seguimiento {
    @Id
    protected int idSeguimiento;
    @ManyToOne
    @JoinColumn(name = "idActividad")
    protected Actividad idActividad;
    @ManyToOne
    @JoinColumn(name = "idUsuario_instructor")
    protected Usuario idUsuario_instructor;
    @ManyToOne
    @JoinColumn(name = "idUsuario_participante")
    protected Usuario idUsuario_participante;
    protected Date fecha_registro;
    protected String comentario;
    protected String aspecto_evaluado;
    protected String nivel_progreso;
    protected String observaciones;
}
