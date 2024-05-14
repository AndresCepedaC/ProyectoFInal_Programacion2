package co.edu.uniquindio.academiaconduccionfx.academiaapp.model;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Administrador;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Instructor;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Secretaria;

public class Sesion {
    private static Sesion instancia;
    private Administrador administrador;
    private Secretaria secretaria;
    private Instructor instructor;

    private Sesion() {
    }

    public static Sesion getInstancia() {
        if (instancia == null) {
            instancia = new Sesion();
        }
        return instancia;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void cerrarSesion() {
        administrador = null;
        secretaria = null;
        instructor = null;
        instancia = null;
    }
}