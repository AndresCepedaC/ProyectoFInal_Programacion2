package co.edu.uniquindio.academiaconduccionfx.academiaapp.model.builder;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;

public class UsuarioBuilder{
    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected int edad;
    protected String correo;
    protected String password;

    public UsuarioBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }


    public UsuarioBuilder setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }


    public UsuarioBuilder setCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public UsuarioBuilder setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public UsuarioBuilder setCorreo(String correo) {
        this.correo = correo;
        return this;
    }
    public UsuarioBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

  public Usuario build(){
return new Usuario(nombre,apellido,cedula, edad, correo, password);
  }


}
