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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sesion")

public class Sesion {
    @Id
    protected int idSesion;
    @ManyToOne
    @JoinColumn(name = "idActividad")
    protected Actividad idActividad;
    @ManyToOne
    @JoinColumn(name = "idEspacio")
    protected Espacio idEspacio;
    protected Date fecha;
    protected Date hora_inicio;
    protected Date hora_finalizacion;
    protected Enums.modalidad modalidad;
    protected String enlace_acceso;
    protected String tema;
}
