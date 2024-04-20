package co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.builder.UsuarioBuilder;

public class Usuario extends Persona{
    private String nombre;
    private String apellido;
    private String cedula;
    private int edad;
    private String correo;
    private String contrasena;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String cedula, int edad,
                   String correo, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.edad = edad;
        this.correo = correo;
        this.contrasena = contrasena;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public static UsuarioBuilder builder(){
        return new UsuarioBuilder();
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", edad='" + edad + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
