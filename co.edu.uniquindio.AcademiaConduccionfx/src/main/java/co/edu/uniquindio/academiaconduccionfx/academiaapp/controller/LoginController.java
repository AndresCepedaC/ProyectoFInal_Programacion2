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
}
