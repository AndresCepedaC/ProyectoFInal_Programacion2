package co.edu.uniquindio.academiaconduccionfx.academiaapp.controller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.factory.ModelFactory;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Instructor;

import java.util.List;

public class InstructorController {

    ModelFactory modelFactory;

    public InstructorController() {
        modelFactory = ModelFactory.getInstance();
    }
    public List<Instructor> obtenerInstructores() {
        return modelFactory.obtenerInstructores();
    }
    public boolean crearInstructor(Instructor instructor){
        return modelFactory.crearInstructor(instructor);
    }

    public Instructor obtenerInstructor(String cedula) {
        return modelFactory.obtenerInstructor(cedula);
    }

    public int encontrarIndiceInstructor(Instructor cedula) {
        return modelFactory.encontrarIndiceInstructor(cedula);
    }
}

