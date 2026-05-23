package com.apirest.backend.model;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Asistencia {
    protected int idAsistencia;
    protected Sesion idSesion;
    protected Usuario idUsuario;
    protected Timestamp hora_registro;
    protected Enums.estado estado;
    protected String observaciones;   
}
