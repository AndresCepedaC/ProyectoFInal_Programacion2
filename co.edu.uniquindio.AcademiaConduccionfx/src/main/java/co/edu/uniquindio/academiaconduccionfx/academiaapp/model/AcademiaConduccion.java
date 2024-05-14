package co.edu.uniquindio.academiaconduccionfx.academiaapp.model;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Administrador;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Instructor;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Secretaria;

import java.util.ArrayList;
import java.util.List;

public class AcademiaConduccion {
    List<Usuario> listaUsuarios = new ArrayList<>();
    List<Administrador> listaAdministradores = new ArrayList<>();
    List<Secretaria> listaSecretarias = new ArrayList<>();
    List<Instructor> listaInstructores = new ArrayList<>();
    List<Curso> listaCursos = new ArrayList<>();
    List<Inscripcion> listaInscripciones = new ArrayList<>();
    private String nombre;

    public AcademiaConduccion() {
        this.nombre = "Academia Conduccion Universidad del Quindio";
    }

    public List<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(List<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public List<Secretaria> getListaSecretarias() {
        return listaSecretarias;
    }

    public void setListaSecretarias(List<Secretaria> listaSecretarias) {
        this.listaSecretarias = listaSecretarias;
    }

    public List<Instructor> getListaInstructores() {
        return listaInstructores;
    }

    public void setListaInstructores(List<Instructor> listaInstructores) {
        this.listaInstructores = listaInstructores;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public List<Inscripcion> getListaInscripciones() {
        return listaInscripciones;
    }

    public void setListaInscripciones(List<Inscripcion> listaInscripciones) {
        this.listaInscripciones = listaInscripciones;
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

    public boolean validarContrasenaInstructor(String usuario, String contrasena) {
        boolean flag = false;
        for (Instructor instructor : listaInstructores) {
            if (instructor.getCedula().equalsIgnoreCase(usuario) && instructor.getPassword().equalsIgnoreCase(contrasena)) {
                flag = true;
            }
        }
        return flag;
    }
    public boolean validarContrasenaSecretaria(String usuario, String contrasena) {
        boolean flag = false;
        for (Secretaria secretaria : listaSecretarias) {
            if (secretaria.getCedula().equalsIgnoreCase(usuario) && secretaria.getPassword().equalsIgnoreCase(contrasena)) {
                flag = true;
            }
        }
        return flag;
    }
    public boolean validarContrasenaAdministrador(String usuario, String contrasena) {
        boolean flag = false;
        for (Administrador administrador : listaAdministradores) {
            if (administrador.getCedula().equalsIgnoreCase(usuario) && administrador.getPassword().equalsIgnoreCase(contrasena)) {
                flag = true;
            }
        }
        return flag;
    }

    public Secretaria encontrarSecretariaID(String text) {
        for (Secretaria secretaria : listaSecretarias) {
            if (secretaria.getCedula().equalsIgnoreCase(text)) {
                return secretaria;
            }
        }
        return null;
    }

    public Administrador encontrarAdministradorID(String text) {
        for (Administrador administrador : listaAdministradores) {
            if (administrador.getCedula().equalsIgnoreCase(text)) {
                return administrador;
            }
        }
        return null;
    }

    public Instructor encontrarInstructorID(String text) {
        for (Instructor instructor : listaInstructores) {
            if (instructor.getCedula().equalsIgnoreCase(text)) {
                return instructor;
            }
        }
        return null;
    }
}
