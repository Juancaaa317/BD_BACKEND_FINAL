package com.apirest.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "espacio")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Espacio {
    @Id
    protected int idEspacio;
    protected String nombre;
    protected String ubicacion;
    protected int capacidad;
    protected String descripcion;
    @Enumerated(EnumType.STRING)
    protected Enums.estadoEspacio estado;
}
