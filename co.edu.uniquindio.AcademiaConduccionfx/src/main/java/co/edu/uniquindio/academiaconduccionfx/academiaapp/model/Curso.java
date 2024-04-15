package co.edu.uniquindio.academiaconduccionfx.academiaapp.model;

public class Curso {
    private Empleado empleado;
    private double valor;

    public Curso(Empleado empleado, double valor) {
        this.empleado = empleado;
        this.valor = valor;
    }

    public Curso() {
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
