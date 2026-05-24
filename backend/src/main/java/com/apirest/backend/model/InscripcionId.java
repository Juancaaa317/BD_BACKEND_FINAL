package com.apirest.backend.model;

import java.io.Serializable;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class InscripcionId implements Serializable  {
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    protected Usuario idUsuario;
    @ManyToOne
    @JoinColumn(name = "idActividad")
    protected Actividad idActividad;
}
