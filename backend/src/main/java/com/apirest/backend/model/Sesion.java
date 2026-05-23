package com.apirest.backend.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Sesion {
    protected int idSesion;
    protected Actividad idActividad;
    protected Espacio idEspacio;
    protected Date fecha;
    protected Date hora_inicio;
    protected Date hora_finalizacion;
    protected Enums.modalidad modalidad;
    protected String tema;
}
