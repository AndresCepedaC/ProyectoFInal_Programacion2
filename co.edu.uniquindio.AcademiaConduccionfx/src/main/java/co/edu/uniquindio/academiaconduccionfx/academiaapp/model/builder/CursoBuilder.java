package co.edu.uniquindio.academiaconduccionfx.academiaapp.model.builder;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Curso;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Inscripcion;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Empleado;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Instructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CursoBuilder {
    protected String idCurso;
    protected String descripcion;
    protected int duracion;
    protected double costo;
    protected Date fechaInicio;
    protected Date fechaFin;
    protected int capacidad;

    public CursoBuilder() {
    }

    public CursoBuilder withIdCurso(String idCurso) {
        this.idCurso = idCurso;
        return this;
    }


    public CursoBuilder withDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public CursoBuilder withDuracion(int duracion) {
        this.duracion = duracion;
        return this;
    }

    public CursoBuilder withCosto(double costo) {
        this.costo = costo;
        return this;
    }

    public CursoBuilder withFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    public CursoBuilder withFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
        return this;
    }

    public CursoBuilder withCapacidad(int capacidad) {
        this.capacidad = capacidad;
        return this;
    }

    public Curso build() {
        return new Curso(idCurso, descripcion, duracion, costo, fechaInicio, fechaFin, capacidad);
    }
}
