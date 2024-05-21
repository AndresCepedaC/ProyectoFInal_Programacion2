package co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Curso;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.builder.InstructorBuilder;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Empleado;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends Empleado {
    private String password;
    private List<Curso> cursosAsociados = new ArrayList<>();
    public Instructor(String nombre, String apellido, String cedula, int edad, String correo, double salario,
                      String password) {
        super(nombre, apellido, cedula, edad, correo, salario);
        this.password = password;
    }
    public static InstructorBuilder builder() {
        return new InstructorBuilder();
    }
    public String getPassword() {
        return password;
    }

    public List<Curso> getCursosAsociados() {
        return cursosAsociados;
    }

    public void setCursosAsociados(List<Curso> cursosAsociados) {
        this.cursosAsociados = cursosAsociados;
    }
}
