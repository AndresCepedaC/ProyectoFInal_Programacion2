package co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.builder.InstructorBuilder;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Empleado;

public class Instructor extends Empleado {
    private String password;
    public Instructor(String nombre, String apellido, String cedula, int edad, String correo, double salario, String password) {
        super(nombre, apellido, cedula, edad, correo, salario);
        this.password = password;
    }
    public static InstructorBuilder builder() {
        return new InstructorBuilder();
    }
    public String getPassword() {
        return password;
    }
}
