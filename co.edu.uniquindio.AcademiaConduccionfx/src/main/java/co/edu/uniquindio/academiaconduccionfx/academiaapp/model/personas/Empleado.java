package co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Persona;

public class Empleado extends Persona {

    private double salario;
    private String password;
    public Empleado(String nombre, String apellido, String cedula, int edad, String correo, double salario) {
        super(nombre, apellido, cedula, edad, correo);
        this.salario = salario;
        this.password = password;
    }
}
