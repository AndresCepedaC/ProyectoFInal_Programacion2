package co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.builder.UsuarioBuilder;

public class Usuario extends Persona{

    private String contrasena;


    public Usuario(String nombre, String apellido, String cedula, int edad,
                   String correo, String contrasena) {
        super(nombre, apellido, cedula, edad, correo);
        this.contrasena = contrasena;
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
                "nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", cedula='" + getCedula() + '\'' +
                ", edad='" + getEdad() + '\'' +
                ", correo='" + getCorreo() + '\'' + '}';
    }
}
