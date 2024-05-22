package co.edu.uniquindio.academiaconduccionfx.academiaapp.controller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.factory.ModelFactory;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Administrador;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Instructor;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Secretaria;

public class LoginController {
    ModelFactory modelFactory = ModelFactory.getInstance();
    public Usuario obtenerUsuario(String text) {
        return modelFactory.obtenerUsuario(text);
    }

    public boolean validarContrasenaInstructor(String usuario, String contrasena) {
        return modelFactory.validarContrasenaInstructor(usuario, contrasena);
    }

    public boolean validarContrasenaAdministrador(String usuario, String contrasena) {
        return modelFactory.validarContrasenaAdministrador(usuario, contrasena);
    }

    public boolean validarContrasenaSecretaria(String usuario, String contrasena) {
        return modelFactory.validarContrasenaSecretaria(usuario, contrasena);
    }

    public Secretaria encontrarSecretariaID(String text) {
        return modelFactory.encontrarSecretariaID(text);
    }

    public Administrador encontrarAdministradorID(String text) {
        return modelFactory.encontrarAdministradorID(text);
    }

    public Instructor encontrarInstructorID(String text) {
        return modelFactory.encontrarInstructorID(text);
    }
}
