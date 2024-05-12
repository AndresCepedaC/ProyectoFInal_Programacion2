package co.edu.uniquindio.academiaconduccionfx.academiaapp.model.builder;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Administrador;

public class AdministradorBuilder {
    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected int edad;
    protected String correo;
    protected double salario;
    protected String password;

    public AdministradorBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }


    public AdministradorBuilder setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }


    public AdministradorBuilder setCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public AdministradorBuilder setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public AdministradorBuilder setCorreo(String correo) {
        this.correo = correo;
        return this;
    }
    public AdministradorBuilder setSalario(double salario) {
        this.salario = salario;
        return this;
    }
    public AdministradorBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public Administrador build(){
        return new Administrador(nombre,apellido,cedula, edad, correo,salario, password);
    }

}
