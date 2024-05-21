package co.edu.uniquindio.academiaconduccionfx.academiaapp.controller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.factory.ModelFactory;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Curso;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.dto.CursoDTO;

import java.util.List;

public class CursoController {
    ModelFactory modelFactory;
    public CursoController() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<Curso> obtenerCursos() {
        return modelFactory.obtenerCursos();
    }

    public void crearCurso(CursoDTO cursoDTO) {
        modelFactory.crearCurso(cursoDTO);
    }

    public Curso obtenerCurso(String IDCurso) {
        return modelFactory.obtenerCurso(IDCurso);
    }

    public boolean eliminarCurso(String IDCurso) {
        return modelFactory.eliminarCurso(IDCurso);
    }
}
