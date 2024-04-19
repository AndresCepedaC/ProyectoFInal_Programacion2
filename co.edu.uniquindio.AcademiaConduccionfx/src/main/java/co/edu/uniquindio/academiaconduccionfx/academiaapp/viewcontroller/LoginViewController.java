package co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.AcademiaApplication;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.controller.LoginController;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.factory.ModelFactory;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Sesion;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Usuario;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.servicios.INavegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LoginViewController implements INavegacion {
    LoginController loginController;
    ModelFactory modelFactory;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtContrasena;

    @FXML
    private TextField txtUsuario;

    @FXML
    void onLogin(ActionEvent event) {
        loginUsuario();
    }


    @FXML
    void initialize() {
        loginController = new LoginController();
    }

    public void loginUsuario() {
        if (!txtUsuario.getText().isEmpty() && !txtContrasena.getText().isEmpty()){
            if (loginController.validarContrasena(txtUsuario.getText(),txtContrasena.getText())) {

                try {
                    Usuario usuario = loginController.obtenerUsuario(txtUsuario.getText());
                    Sesion sesion = Sesion.getInstancia();
                    sesion.setUsuario(usuario);
                    irPantalla("Usuario.fxml", "/panel");
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error al iniciar sesión");
                    alert.setContentText("Sus datos de acceso son errones.");
                    alert.showAndWait();
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al iniciar sesión");
            alert.setContentText("Todos los campos son obligatorios para continuar.");
            alert.showAndWait();}
    }
}