package co.edu.uniquindio.academiaconduccionfx.academiaapp.controller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.factory.ModelFactory;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;

public class RegisterController {
    ModelFactory modelFactory = ModelFactory.getInstance();
    public boolean agregarUsuario(Usuario usuario) {
        return modelFactory.agregarUsuario(usuario);
    }

    public boolean crearUsuario(Usuario usuarioNuevo) {
        return modelFactory.crearUsuario(usuarioNuevo);
    }
}
