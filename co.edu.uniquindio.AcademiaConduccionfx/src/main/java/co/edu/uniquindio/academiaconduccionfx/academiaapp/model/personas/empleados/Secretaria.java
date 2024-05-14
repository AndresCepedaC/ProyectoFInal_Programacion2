package co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.builder.AdministradorBuilder;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.builder.SecretariaBuilder;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Empleado;

public class Secretaria extends Empleado {
    private String password;
    public Secretaria(String nombre, String apellido, String cedula, int edad, String correo, double salario, String password) {
        super(nombre, apellido, cedula, edad, correo, salario);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public static SecretariaBuilder builder() {
        return new SecretariaBuilder();
    }
}
