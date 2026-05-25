package com.apirest.backend.model;

import java.util.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "inscripcion")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Inscripcion {
    @EmbeddedId
    protected InscripcionId id;
    protected Date fechaInscripcion;
    @Enumerated(EnumType.STRING)
    protected Enums.estadoInscripcion estado;
}
