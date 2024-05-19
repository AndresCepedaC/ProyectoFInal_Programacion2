package co.edu.uniquindio.academiaconduccionfx.academiaapp.controller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.factory.ModelFactory;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Secretaria;

import java.util.List;

public class SecretariaController {

    ModelFactory modelFactory;

    public SecretariaController() {
        modelFactory = ModelFactory.getInstance();
    }
    public List<Secretaria> obtenerSecretarias() {
        return modelFactory.obtenerSecretarias();
    }
    public boolean crearSecretaria(Secretaria secretaria){
        return modelFactory.crearSecretaria(secretaria);
    }

    public Secretaria obtenerSecretaria(String cedula) {
        return modelFactory.obtenerSecretaria(cedula);
    }

    public int encontrarIndiceSecretaria(Secretaria cedula) {
        return modelFactory.encontrarIndiceSecretaria(cedula);
    }
}

