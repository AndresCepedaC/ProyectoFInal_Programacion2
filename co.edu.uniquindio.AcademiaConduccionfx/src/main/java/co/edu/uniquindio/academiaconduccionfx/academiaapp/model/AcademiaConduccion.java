package co.edu.uniquindio.academiaconduccionfx.academiaapp.model;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;

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
                                String correo,
                                String password){
        Usuario usuarioEncontrado = obtenerUsuario(cedula);
        if(usuarioEncontrado == null){
            Usuario usuario = getBuildUsuario(nombre, apellido, cedula, edad, correo, password);
            getListaUsuarios().add(usuario);
            return true;
        }else{
            return  false;
        }
    }
    private Usuario getBuildUsuario(String nombre, String apellido, String cedula, int edad, String correo, String password) {
        return Usuario.builder()
                .setApellido(apellido)
                .setCedula(cedula)
                .setCorreo(correo)
                .setEdad(edad)
                .setNombre(nombre)
                .setPassword(password)
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

    public boolean validarContrasena(String cedula, String contrasena) {
        Usuario usuarioEncontrado = obtenerUsuario(cedula);
        if (usuarioEncontrado != null){
            if (usuarioEncontrado.getContrasena().equalsIgnoreCase(contrasena)){
                return true;
            }
        }
        return false;
    }

    public boolean agregarUsuario(Usuario usuario) {
        if (usuario != null){
            for (Usuario usuario1 : listaUsuarios){
                if (usuario == usuario1){
                    return false;
                }else {
                    listaUsuarios.add(usuario);
                    return true;
            }
        }
        }
        return false;
    }
}
