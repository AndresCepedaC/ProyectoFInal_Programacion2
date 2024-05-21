package co.edu.uniquindio.academiaconduccionfx.academiaapp.controller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.factory.ModelFactory;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Curso;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Inscripcion;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.dto.CursoDTO;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Instructor;

public class CursoListasContoller {
    ModelFactory modelFactory;
    public CursoListasContoller() {
        modelFactory = ModelFactory.getInstance();
    }

    public Inscripcion obtenerInscripcion(String ID) {
        return modelFactory.obtenerInscripcion(ID);
    }

    public Instructor obtenerInstructor(String cedula) {
        return modelFactory.obtenerInstructor(cedula);
    }

    public boolean actualizarCurso(Curso curso) {
        return modelFactory.actualizarCurso(curso);
    }

    public boolean crearCurso(CursoDTO curso) {
        return modelFactory.crearCurso(curso);
    }

    public int obtenerIndexCurso(Curso curso) {
        return modelFactory.obtenerIndexCurso(curso);
    }
}
