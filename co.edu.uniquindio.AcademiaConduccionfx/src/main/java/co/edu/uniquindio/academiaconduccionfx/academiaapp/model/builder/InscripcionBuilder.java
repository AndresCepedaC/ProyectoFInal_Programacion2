package co.edu.uniquindio.academiaconduccionfx.academiaapp.model.builder;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Curso;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Enum.CategoriaLicencia;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Inscripcion;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Instructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InscripcionBuilder {
    protected LocalDate fechaInscripcion;
    protected Curso curso;
    protected String estado;
    protected Usuario usuario;
    protected String numeroInscripcion;
    protected CategoriaLicencia categoriaLicencia;

    public InscripcionBuilder() {
    }

    public InscripcionBuilder withFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
        return this;
    }

    public InscripcionBuilder withCurso(Curso curso) {
        this.curso = curso;
        return this;
    }

    public InscripcionBuilder withEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public InscripcionBuilder withUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public InscripcionBuilder withNumeroInscripcion(String numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
        return this;
    }
    public InscripcionBuilder withCategoriaLicencia(CategoriaLicencia categoriaLicencia) {
        this.categoriaLicencia = categoriaLicencia;
        return this;
    }
    public Inscripcion build() {
        return new Inscripcion(fechaInscripcion, curso, estado, usuario, numeroInscripcion, categoriaLicencia);
    }
}
