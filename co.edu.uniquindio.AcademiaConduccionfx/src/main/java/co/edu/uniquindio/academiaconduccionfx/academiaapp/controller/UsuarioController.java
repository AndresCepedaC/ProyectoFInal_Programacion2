package co.edu.uniquindio.academiaconduccionfx.academiaapp.controller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.factory.ModelFactory;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Usuario;

import java.util.List;

public class UsuarioController {

    ModelFactory modelFactory;

    public UsuarioController() {
        modelFactory = ModelFactory.getInstance();
    }
    public List<Usuario> obtenerUsuarios() {
        return modelFactory.obtenerUsuarios();
    }
    public boolean crearUsuario(Usuario usuario){
        return modelFactory.crearUsuario(usuario);
    }

    public Usuario obtenerUsuario(String cedula) {
        return modelFactory.obtenerUsuario(cedula);
    }

    public int encontrarIndiceUsuario(Usuario cedula) {
        return modelFactory.encontrarIndiceUsuario(cedula);
    }
}

