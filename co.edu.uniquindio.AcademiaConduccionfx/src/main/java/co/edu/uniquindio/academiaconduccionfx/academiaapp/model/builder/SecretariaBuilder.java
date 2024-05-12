package co.edu.uniquindio.academiaconduccionfx.academiaapp.model.builder;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Administrador;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Secretaria;

public class SecretariaBuilder {
    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected int edad;
    protected String correo;
    protected double salario;
    protected String password;

    public SecretariaBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }


    public SecretariaBuilder setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }


    public SecretariaBuilder setCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public SecretariaBuilder setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public SecretariaBuilder setCorreo(String correo) {
        this.correo = correo;
        return this;
    }
    public SecretariaBuilder setSalario(double salario) {
        this.salario = salario;
        return this;
    }
    public SecretariaBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public Secretaria build(){
        return new Secretaria(nombre,apellido,cedula, edad, correo,salario, password);
    }

}
