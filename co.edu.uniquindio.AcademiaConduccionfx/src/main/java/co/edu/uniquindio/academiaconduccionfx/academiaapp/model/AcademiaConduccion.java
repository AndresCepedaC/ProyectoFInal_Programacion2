package co.edu.uniquindio.academiaconduccionfx.academiaapp.model;

import java.util.ArrayList;
import java.util.List;

public class AcademiaConduccion {
    List<Usuario> listaUsuarios = new ArrayList<>();

    private String nombre;

    public AcademiaConduccion() {
    }

    public boolean crearUsuario(String nombre,
                                String apellido,
                                String cedula,
                                int edad,
                                String correo){
        Usuario usuarioEncontrado = obtenerUsuario(cedula);
        if(usuarioEncontrado == null){
            Usuario usuario = getBuildUsuario(nombre, apellido, cedula, edad, correo);
            getListaUsuarios().add(usuario);
            return true;
        }else{
            return  false;
        }
    }
    private Usuario getBuildUsuario(String nombre, String apellido, String cedula, int edad, String correo) {
        return Usuario.builder()
                .setApellido(apellido)
                .setCedula(cedula)
                .setCorreo(correo)
                .setEdad(edad)
                .setNombre(nombre)
                .build();
    }
    public Usuario obtenerUsuario(String cedula) {
        Usuario usuario = null;
        for (Usuario usuario1: getListaUsuarios()) {
            if(usuario1.getCedula().equalsIgnoreCase(cedula)){
                usuario = usuario1;
                break;
            }
        }

        return usuario;
    }
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean crearUsuario(Usuario usuario) {
        Usuario usuarioEncontrado = obtenerUsuario(usuario.getCedula());
        if (usuarioEncontrado == null){
            getListaUsuarios().add(usuario);
            return true;
        }else {
            return false;
        }
    }

    public int encontrarIndiceUsuario(Usuario cedula) {
        int counter = 0;
        for (int i = 0; i<listaUsuarios.size(); i++){
            counter += 1;
            if (listaUsuarios.get(i) == cedula){
                break;
            }
        }
        return counter;

    }
}
