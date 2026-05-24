package com.apirest.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "espacio")

public class Espacio {
    @Id
    protected int idEspacio;
    protected String nombre;
    protected String ubicacion;
    protected int capacidad;
    protected String descripcion;
    protected Enums.estadoEspacio estado;
}
