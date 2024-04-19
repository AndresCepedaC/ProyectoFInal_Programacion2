package co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.controller.RegisterController;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.factory.ModelFactory;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Sesion;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class RegisterViewController {
    RegisterController registerController;
    ModelFactory modelFactory;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtAllName;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnRegistro;

    @FXML
    private TextField txtPassword;

    @FXML
    void onRegistro(ActionEvent event) {
        registrarUsuario();
    }


    @FXML
    void initialize() {
        registerController = new RegisterController();
    }

    private void registrarUsuario() {
        if (validarFormulario()){
            Usuario usuario = Usuario.builder()
                    .setNombre(txtAllName.getText())
                    .setCorreo(txtEmail.getText())
                    .setCedula(txtID.getText())
                    .build();
            usuario.setContrasena(txtPassword.getText());
            if (registerController.agregarUsuario(usuario)){
                mostrarMensajeConfirmacion("El usuario se ha agregado correctamente");
            }else {
                mostrarMensajeConfirmacion("El usuario no ha sido agregado correctamente, verifique los datos ingresados");
            }
        }
    }

    private boolean validarFormulario() {
        if (txtAllName.getText().isEmpty()){
            return false;
        }else if (txtEmail.getText().isEmpty()){
            return false;
        }else if (txtID.getText().isEmpty()){
            return false;
        }else if (txtPassword.getText().isEmpty()){
            return false;
        }
        return true;
    }
    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
}
