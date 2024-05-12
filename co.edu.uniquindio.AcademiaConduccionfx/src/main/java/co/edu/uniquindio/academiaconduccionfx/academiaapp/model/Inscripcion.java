package co.edu.uniquindio.academiaconduccionfx.academiaapp.model;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Empleado;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Inscripcion {
    private Usuario  usuario;
    List<Curso> cursosAsociados = new ArrayList<>();
    private Empleado empleadoAsociado;
    private int numeroInscripcion;

}
