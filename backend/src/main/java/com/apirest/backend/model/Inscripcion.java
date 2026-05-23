package com.apirest.backend.model;

import java.util.Date;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Inscripcion {
    @Id
    protected InscripcionId id;
    protected Date fecha_inscripcion;
    protected Enums.estadoInscripcion estado;
}
