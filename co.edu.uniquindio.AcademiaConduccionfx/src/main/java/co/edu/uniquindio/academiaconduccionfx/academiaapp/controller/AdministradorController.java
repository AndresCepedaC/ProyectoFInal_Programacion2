package co.edu.uniquindio.academiaconduccionfx.academiaapp.controller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.factory.ModelFactory;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Administrador;

import java.util.List;

public class AdministradorController {

    ModelFactory modelFactory;

    public AdministradorController() {
        modelFactory = ModelFactory.getInstance();
    }
    public List<Administrador> obtenerAdministradores() {
        return modelFactory.obtenerAdministradores();
    }
    public boolean crearAdministrador(Administrador administrador){
        return modelFactory.crearAdministrador(administrador);
    }

    public Administrador obtenerAdministrador(String cedula) {
        return modelFactory.obtenerAdministrador(cedula);
    }

    public int encontrarIndiceAdministrador(Administrador cedula) {
        return modelFactory.encontrarIndiceAdministrador(cedula);
    }
}

