package co.edu.uniquindio.academiaconduccionfx.academiaapp.factory;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.AcademiaConduccion;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Administrador;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Instructor;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Secretaria;

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
        initUsuarios();
        initAdministradores();
        initSecretarias();
        initInstructores();
    }



    public List<Usuario> obtenerUsuarios() {
        return academiaConduccion.getListaUsuarios();
    }
    public List<Secretaria> obtenerSecretarias() {
        return academiaConduccion.getListaSecretarias();
    }
    public List<Administrador> obtenerAdministradores() {
        return academiaConduccion.getListaAdministradores();
    }
    public List<Instructor> obtenerInstructores() {
        return academiaConduccion.getListaInstructores();
    }


    public boolean crearUsuario(Usuario usuario) {
        return academiaConduccion.crearUsuario(usuario);
    }
    public boolean crearSecretaria(Secretaria secretaria) {
        return academiaConduccion.crearSecretaria(secretaria);
    }
    public boolean crearInstructor(Instructor instructor) {
        return academiaConduccion.crearInstructor(instructor);
    }
    public boolean crearAdministrador(Administrador administrador) {
        return academiaConduccion.crearAdministrador(administrador);
    }

    public Usuario obtenerUsuario(String cedula) {
        return academiaConduccion.obtenerUsuario(cedula);
    }
    public Secretaria obtenerSecretaria(String cedula) {
        return academiaConduccion.obtenerSecretaria(cedula);
    }
    public Instructor obtenerInstructor(String cedula) {
        return academiaConduccion.obtenerInstructor(cedula);
    }
    public Administrador obtenerAdministrador(String cedula) {
        return academiaConduccion.obtenerAdministrador(cedula);
    }

    public int encontrarIndiceUsuario(Usuario cedula) {
        return academiaConduccion.encontrarIndiceUsuario(cedula);
    }
    public int encontrarIndiceSecretaria(Secretaria cedula) {
        return academiaConduccion.encontrarIndiceSecretaria(cedula);
    }
    public int encontrarIndiceInstructor(Instructor cedula) {
        return academiaConduccion.encontrarIndiceInstructor(cedula);
    }
    public int encontrarIndiceAdministrador(Administrador cedula) {
        return academiaConduccion.encontrarIndiceAdministrador(cedula);
    }

    public boolean validarContrasena(String cedula, String contrasena) {
        return academiaConduccion.validarContrasena(cedula,contrasena);
    }
    private void initUsuarios() {
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
    private void initAdministradores() {
        Administrador administrador = Administrador.builder()
                .setNombre("Emmanuel")
                .setApellido("Doble A")
                .setCedula("223")
                .setCorreo("Ema@24")
                .setEdad(27)
                .setPassword("223")
                .build();
        Administrador administrador2 = Administrador.builder()
                .setNombre("John")
                .setApellido("Caicedo")
                .setCedula("221")
                .setCorreo("John@32")
                .setEdad(31)
                .setPassword("221")
                .build();
        Administrador administrador3 = Administrador.builder()
                .setNombre("Natalia")
                .setApellido("Santos")
                .setCedula("113")
                .setCorreo("Nat@43")
                .setEdad(32)
                .setPassword("113")
                .build();
        Administrador administrador4 = Administrador.builder()
                .setNombre("Elon")
                .setApellido("Musk")
                .setCedula("876")
                .setCorreo("Musk@98")
                .setEdad(40)
                .setPassword("876")
                .build();
        academiaConduccion.getListaAdministradores().add(administrador);
        academiaConduccion.getListaAdministradores().add(administrador2);
        academiaConduccion.getListaAdministradores().add(administrador3);
        academiaConduccion.getListaAdministradores().add(administrador4);
    }

    private void initSecretarias() {
        Secretaria secretaria = Secretaria.builder()
                .setNombre("Roberta")
                .setApellido("Firminho")
                .setCedula("442")
                .setCorreo("Rob@98")
                .setEdad(54)
                .setPassword("442")
                .build();
        Secretaria secretaria2 = Secretaria.builder()
                .setNombre("Marta")
                .setApellido("Santos")
                .setCedula("222")
                .setCorreo("Mart@22")
                .setEdad(52)
                .setPassword("222")
                .build();
        Secretaria secretaria3 = Secretaria.builder()
                .setNombre("Antonella")
                .setApellido("Messi")
                .setCedula("100")
                .setCorreo("Anto@100")
                .setEdad(38)
                .setPassword("100")
                .build();
        Secretaria secretaria4 = Secretaria.builder()
                .setNombre("Diana")
                .setApellido("Villamil")
                .setCedula("666")
                .setCorreo("Diana@65")
                .setEdad(45)
                .setPassword("666")
                .build();
        academiaConduccion.getListaSecretarias().add(secretaria);
        academiaConduccion.getListaSecretarias().add(secretaria2);
        academiaConduccion.getListaSecretarias().add(secretaria3);
        academiaConduccion.getListaSecretarias().add(secretaria4);
    }

    private void initInstructores() {
        Instructor instructor = Instructor.builder()
                .setNombre("Jose")
                .setApellido("Vargas")
                .setCedula("555")
                .setCorreo("Jose@32")
                .setEdad(56)
                .setPassword("555")
                .build();
        Instructor instructor2 = Instructor.builder()
                .setNombre("Ricardo")
                .setApellido("Arjona")
                .setCedula("777")
                .setCorreo("Ric@542")
                .setEdad(48)
                .setPassword("777")
                .build();
        Instructor instructor3 = Instructor.builder()
                .setNombre("Jhony")
                .setApellido("Madrazo")
                .setCedula("111")
                .setCorreo("Mad@11")
                .setEdad(65)
                .setPassword("111")
                .build();
        Instructor instructor4 = Instructor.builder()
                .setNombre("Oscar")
                .setApellido("Jimenez")
                .setCedula("543")
                .setCorreo("Oscar@34")
                .setEdad(42)
                .setPassword("543")
                .build();
        academiaConduccion.getListaInstructores().add(instructor);
        academiaConduccion.getListaInstructores().add(instructor2);
        academiaConduccion.getListaInstructores().add(instructor3);
        academiaConduccion.getListaInstructores().add(instructor4);
    }
    public boolean agregarUsuario(Usuario usuario) {
        return academiaConduccion.agregarUsuario(usuario);

    }

    public boolean validarContrasenaInstructor(String usuario, String contrasena) {
        return academiaConduccion.validarContrasenaInstructor(usuario, contrasena);
    }

    public boolean validarContrasenaAdministrador(String usuario, String contrasena) {
        return academiaConduccion.validarContrasenaAdministrador(usuario, contrasena);
    }

    public boolean validarContrasenaSecretaria(String usuario, String contrasena) {
        return academiaConduccion.validarContrasenaSecretaria(usuario, contrasena);
    }

    public Secretaria encontrarSecretariaID(String text) {
        return academiaConduccion.encontrarSecretariaID(text);
    }

    public Administrador encontrarAdministradorID(String text) {
        return academiaConduccion.encontrarAdministradorID(text);
    }

    public Instructor encontrarInstructorID(String text) {
        return academiaConduccion.encontrarInstructorID(text);
    }
}
