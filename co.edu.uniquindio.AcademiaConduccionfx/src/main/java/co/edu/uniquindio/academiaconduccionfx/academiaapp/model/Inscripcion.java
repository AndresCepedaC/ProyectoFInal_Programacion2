package co.edu.uniquindio.academiaconduccionfx.academiaapp.model;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Enum.CategoriaLicencia;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.builder.InscripcionBuilder;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Empleado;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Instructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Inscripcion {
    private Date fechaInscripcion;
    private Curso curso;
    private String estado;
    private Usuario  usuario;
    private int numeroInscripcion;
    private CategoriaLicencia categoriaLicencia;
    private List<Curso> cursosAsociados = new ArrayList<>();


    public Inscripcion(Date fechaInscripcion, Curso curso,
                       String estado, Usuario usuario,
                       int numeroInscripcion,
                       CategoriaLicencia categoriaLicencia) {
        this.fechaInscripcion = fechaInscripcion;
        this.curso = curso;
        this.estado = estado;
        this.usuario = usuario;
        this.numeroInscripcion = numeroInscripcion;
        this.categoriaLicencia = categoriaLicencia;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public Curso getCurso() {
        return curso;
    }

    public String getEstado() {
        return estado;
    }

    public CategoriaLicencia getCategoriaLicencia() {
        return categoriaLicencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Curso> getCursosAsociados() {
        return cursosAsociados;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public static InscripcionBuilder builder() {
        return new InscripcionBuilder();
    }
}
