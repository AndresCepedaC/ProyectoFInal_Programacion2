package co.edu.uniquindio.academiaconduccionfx.academiaapp.controller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.factory.ModelFactory;

public class AcademiaController {
    ModelFactory modelFactory;
    public AcademiaController() {
        modelFactory = ModelFactory.getInstance();
    }
}
