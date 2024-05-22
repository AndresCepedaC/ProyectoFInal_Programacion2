package co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.builder.UsuarioBuilder;

public class Usuario extends Persona{
    public Usuario(String nombre, String apellido, String cedula, int edad,
                   String correo) {
        super(nombre, apellido, cedula, edad, correo);
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
