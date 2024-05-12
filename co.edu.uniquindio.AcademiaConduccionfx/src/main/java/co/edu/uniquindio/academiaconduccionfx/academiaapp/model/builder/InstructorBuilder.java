package co.edu.uniquindio.academiaconduccionfx.academiaapp.model.builder;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Administrador;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Instructor;

public class InstructorBuilder {
    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected int edad;
    protected String correo;
    protected double salario;
    protected String password;

    public InstructorBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }


    public InstructorBuilder setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }


    public InstructorBuilder setCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public InstructorBuilder setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public InstructorBuilder setCorreo(String correo) {
        this.correo = correo;
        return this;
    }
    public InstructorBuilder setSalario(double salario) {
        this.salario = salario;
        return this;
    }
    public InstructorBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public Instructor build(){
        return new Instructor(nombre,apellido,cedula, edad, correo,salario, password);
    }

}
