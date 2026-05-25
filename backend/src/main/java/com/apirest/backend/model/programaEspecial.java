package com.apirest.backend.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    protected Integer idPrograma;
    protected String nombre;
    protected String descripcion;
    protected Date fecha_inicio;
    protected Date fecha_fin;
    protected String poblacion_objetivo;
    @Enumerated(EnumType.STRING)
    protected Enums.tipo tipo;
}
