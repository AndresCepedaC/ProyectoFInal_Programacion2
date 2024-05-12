package co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas;

public class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;
    private String correo;

    public Persona(String nombre, String apellido, String cedula, int edad, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }
}
