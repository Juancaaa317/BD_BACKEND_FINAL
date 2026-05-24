package com.apirest.backend.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    protected int idUsuario;
    protected String nombre_completo;
    protected int documento_identificacion;
    protected int edad;
    protected String email;
    protected int telefono;
    protected String direccion_residencia;

    protected Enums.rol rol;
}
