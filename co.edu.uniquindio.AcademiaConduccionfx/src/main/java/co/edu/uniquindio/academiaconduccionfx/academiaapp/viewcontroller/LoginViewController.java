package co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.controller.LoginController;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.factory.ModelFactory;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Sesion;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Administrador;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Instructor;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Secretaria;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.servicios.INavegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.skin.CellSkinBase;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class LoginViewController implements INavegacion {
    LoginController loginController;
    ModelFactory modelFactory;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup Group1;

    @FXML
    private RadioButton rBtnSecretaria;

    @FXML
    private Button btnLogin;

    @FXML
    private RadioButton rBtnAdministrador;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private RadioButton rBtnInstructor;
    @FXML
    private TextField txtUsuario;
    @FXML
    private Hyperlink linkRegistrarse;
    @FXML
    void onLogin(ActionEvent event) {
        login();
    }
    @FXML
    void initialize() {
        loginController = new LoginController();
        limpiarCampos();
    }
    public void login() {
        if (rBtnInstructor.isSelected()) {
            if (validarFormulario("instructor")) {
                inicioSesionInstructor();
            }
        } else if (rBtnAdministrador.isSelected()) {
            if (validarFormulario("administrador")) {
                inicioSesionAdministrador();
            }
        } else if (rBtnSecretaria.isSelected()) {
            if (validarFormulario("secretaria")) {
                inicioSesionSecretaria();
            }
        } else {
            mostrarMensaje("Error", "Error, debe seleccionar un tipo",
                    "Debe seleccionar como qué tipo de persona quiere ingresar",
                    Alert.AlertType.ERROR);
        }
    }

    private void inicioSesionSecretaria() {
        if (loginController.validarContrasenaSecretaria(txtUsuario.getText(), txtContrasena.getText())) {
            cerrarVentanaActual();
            irPantalla("PanelSecretaria.fxml", "Panel secretaria");
            Secretaria secretaria = loginController.encontrarSecretariaID(txtUsuario.getText());
            mostrarMensaje("Bienvenido", "Bienvenido", "Bienvenido "+secretaria.getNombre(), Alert.AlertType.INFORMATION);
        } else {
            mostrarMensaje("Error al iniciar sesión", "Error al iniciar sesión", "Error al iniciar sesión, por favor verifique sus datos", Alert.AlertType.ERROR);
        }
    }

    private void inicioSesionAdministrador() {
        if (loginController.validarContrasenaAdministrador(txtUsuario.getText(), txtContrasena.getText())) {
            cerrarVentanaActual();
            irPantalla("PanelAdministrador.fxml", "Panel administrador");
            Administrador administrador = loginController.encontrarAdministradorID(txtUsuario.getText());
            mostrarMensaje("Bienvenido", "Bienvenido", "Bienvenido "+administrador.getNombre(), Alert.AlertType.INFORMATION);
        } else {
            mostrarMensaje("Error al iniciar sesión", "Error al iniciar sesión", "Error al iniciar sesión, por favor verifique sus datos", Alert.AlertType.ERROR);
        }
    }

    private void inicioSesionInstructor() {
        if (loginController.validarContrasenaInstructor(txtUsuario.getText(), txtContrasena.getText())) {
            cerrarVentanaActual();
            irPantalla("PanelInstructor.fxml", "Panel instructor");
            Instructor instructor = loginController.encontrarInstructorID(txtUsuario.getText());
            mostrarMensaje("Bienvenido", "Bienvenido", "Bienvenido "+instructor.getNombre(), Alert.AlertType.INFORMATION);
        } else {
            mostrarMensaje("Error al iniciar sesión", "Error al iniciar sesión", "Error al iniciar sesión, por favor verifique sus datos", Alert.AlertType.ERROR);
        }
    }

    private boolean validarFormulario(String tipoUsuario) {
        if (txtUsuario.getText().isEmpty() || txtContrasena.getText().isEmpty()) {
            mostrarMensaje("Error", "Error al iniciar sesión", "Todos los campos son obligatorios para continuar.", Alert.AlertType.ERROR);
            return false;
        }
        return true;
    }
    private boolean validarFormulario() {
        if (txtUsuario.getText().isEmpty() || txtContrasena.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private void limpiarCampos() {
        txtContrasena.setText("");
        txtUsuario.setText("");
    }
    private void cerrarVentanaActual() {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.close();
    }
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
    @FXML
    public void onRegistrarse(ActionEvent actionEvent) {
        irPantalla("Login/Registro.fxml", "Registro");
        cerrarVentanaActual();
    }
}