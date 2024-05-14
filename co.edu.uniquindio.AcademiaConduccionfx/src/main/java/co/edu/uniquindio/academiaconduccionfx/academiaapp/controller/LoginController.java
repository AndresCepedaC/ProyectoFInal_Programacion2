package co.edu.uniquindio.academiaconduccionfx.academiaapp.controller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.factory.ModelFactory;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;

public class LoginController {
    ModelFactory modelFactory = ModelFactory.getInstance();
    public Usuario obtenerUsuario(String text) {
        return modelFactory.obtenerUsuario(text);
    }

    public boolean validarContrasena(String cedula, String contrasena) {
        return modelFactory.validarContrasena(cedula, contrasena);
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
}
