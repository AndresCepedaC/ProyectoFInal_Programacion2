package co.edu.uniquindio.academiaconduccionfx.academiaapp.factory;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.AcademiaConduccion;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Usuario;

import java.util.List;

public class ModelFactory {

    private static ModelFactory modelFactory;
    private AcademiaConduccion academiaConduccion;
    private ModelFactory(){
        academiaConduccion = new AcademiaConduccion();
        inicializarDatos();
    }

    public static ModelFactory getInstance(){
        if(modelFactory == null){
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private void inicializarDatos() {
        Usuario usuario = Usuario.builder()
                .setNombre("Jorge")
                .setApellido("Montoya")
                .setCedula("123")
                .setCorreo("Jor@24")
                .setEdad(20)
                .build();

        Usuario usuario2 = Usuario.builder()
                .setNombre("Maria")
                .setApellido("Ortiz")
                .setCedula("1098")
                .setCorreo("mari@87")
                .setEdad(19)
                .build();

        Usuario usuario3 = Usuario.builder()
                .setNombre("Jimena")
                .setApellido("Garcia")
                .setCedula("1097")
                .setCorreo("Jime@34")
                .setEdad(22)
                .build();

        Usuario usuario4 = Usuario.builder()
                .setNombre("Maicol")
                .setApellido("Reyes")
                .setCedula("1090")
                .setCorreo("mai@27")
                .setEdad(26)
                .build();

        usuario.setContrasena("123");
        usuario2.setContrasena("1234");
        usuario3.setContrasena("1235");
        usuario4.setContrasena("1236");

        academiaConduccion.getListaUsuarios().add(usuario);
        academiaConduccion.getListaUsuarios().add(usuario2);
        academiaConduccion.getListaUsuarios().add(usuario3);
        academiaConduccion.getListaUsuarios().add(usuario4);
    }


    public List<Usuario> obtenerUsuarios() {
        return academiaConduccion.getListaUsuarios();
    }

    public boolean crearUsuario(Usuario usuario) {
        return academiaConduccion.crearUsuario(usuario);
    }

    public Usuario obtenerUsuario(String cedula) {
        return academiaConduccion.obtenerUsuario(cedula);
    }

    public int encontrarIndiceUsuario(Usuario cedula) {
        return academiaConduccion.encontrarIndiceUsuario(cedula);
    }

    public boolean validarContrasena(String text, String text1) {
        return academiaConduccion.validarContrasena(text,text1);
    }

    public boolean agregarUsuario(Usuario usuario) {
        return academiaConduccion.agregarUsuario(usuario);

    }
}
