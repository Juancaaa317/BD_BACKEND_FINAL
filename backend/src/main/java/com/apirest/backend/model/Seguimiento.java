package com.apirest.backend.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Seguimiento {
    protected int idSeguimiento;
    protected Actividad idActividad;
    protected Usuario idUsuario_instructor;
    protected Usuario idUsuario_participante;
    protected Date fecha_registro;
    protected String comentario;
    protected String aspecto_evaluado;
    protected String nivel_progreso;
    protected String observaciones;
}
