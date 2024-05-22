package co.edu.uniquindio.academiaconduccionfx.academiaapp.model;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.builder.CursoBuilder;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Instructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Curso {
    private String idCurso;
    private String descripcion;
    private int duracion;
    private double costo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int capacidad;
    private List<Instructor> instructoresAsociados = new ArrayList<>();
    private List<Inscripcion> inscripcionesAsociadas = new ArrayList<>();

    public Curso() {
    }

    public Curso(String idCurso,
                 String descripcion,
                 int duracion, double costo,
                 LocalDate fechaInicio, LocalDate fechaFin,
                 int capacidad) {
        this.idCurso = idCurso;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.capacidad = capacidad;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public double getCosto() {
        return costo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public List<Instructor> getInstructoresAsociados() {
        return instructoresAsociados;
    }

    public List<Inscripcion> getInscripcionesAsociadas() {
        return inscripcionesAsociadas;
    }
    public static CursoBuilder builder() {
        return new CursoBuilder();
    }
}
