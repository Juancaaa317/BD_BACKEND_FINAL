package com.apirest.backend.model;

import java.sql.Timestamp;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="asistencia")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Asistencia {
    @Id
    protected int idAsistencia;
    @ManyToOne
    @JoinColumn(name = "idSesion")
    protected Sesion idSesion;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    protected Usuario idUsuario;
    protected Timestamp hora_registro;
    protected Enums.estado estado;
    protected String observaciones;   
}
