package com.apirest.backend.model;

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
@Table(name="usuario")
public class Usuario {
    @Id
    protected Integer idUsuario;
    protected String nombre_completo;
    protected Integer documento_identificacion;
    protected Integer edad;
    protected String email;
    protected Integer telefono;
    protected String direccion_residencia;
    @Enumerated(EnumType.STRING)
    protected Enums.rol rol;
}
