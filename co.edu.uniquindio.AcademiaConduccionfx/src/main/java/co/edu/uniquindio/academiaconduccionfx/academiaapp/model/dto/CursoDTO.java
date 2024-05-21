package co.edu.uniquindio.academiaconduccionfx.academiaapp.model.dto;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Inscripcion;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Instructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CursoDTO {
    public String idCurso;
    public String descripcion;
    public int duracion;
    public double costo;
    public Date fechaInicio;
    public Date fechaFin;
    public int capacidad;
    public List<Instructor> instructoresAsociados = new ArrayList<>();
    public List<Inscripcion> inscripcionesAsociadas = new ArrayList<>();
}