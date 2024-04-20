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
    private TextField txtID;

    @FXML
    private TextField txtConfirmPassword;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtApellido;

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
            if (confirmarPassword()){
                Usuario usuarioNuevo = construirDatosUsuario();
                if (registerController.crearUsuario(usuarioNuevo)){
                    limpiarCampos();
                    mostrarMensajeConfirmacion("El usuario se ha agregado correctamente", "Confirmacion usuario", Alert.AlertType.CONFIRMATION);
                }else {
                    mostrarMensajeConfirmacion("El usuario no ha sido agregado correctamente, verifique los datos ingresados", "Error", Alert.AlertType.ERROR);
                }
            }
            else {
                mostrarMensajeConfirmacion("Las contrasenas no son iguales, verifique y vuelva a intentar", "Error", Alert.AlertType.ERROR);
            }
        }
    }

    private boolean confirmarPassword() {
        if (txtPassword.getText().equalsIgnoreCase(txtConfirmPassword.getText())){
            return true;
        }
        return false;
    }

    private void limpiarCampos() {
        txtName.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        txtEmail.setText("");
        txtEdad.setText("");
        txtID.setText("");
        txtApellido.setText("");
    }

    private Usuario construirDatosUsuario(){
        return Usuario.builder()
                .setNombre(txtName.getText())
                .setEdad(Integer.parseInt( txtEdad.getText()))
                .setCorreo(txtEmail.getText())
                .setCedula(txtID.getText())
                .setApellido(txtApellido.getText())
                .setPassword(txtPassword.getText())
                .build();
    }
    private boolean validarFormulario() {
        if (txtName.getText().isEmpty() ||
                txtEmail.getText().isEmpty() ||
                txtID.getText().isEmpty() ||
                txtPassword.getText().isEmpty() ||
                txtEdad.getText().isEmpty() ||
                txtConfirmPassword.getText().isEmpty() ||
                txtApellido.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean mostrarMensajeConfirmacion(String mensaje, String tipoMensaje, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(null);
        alert.setTitle(tipoMensaje);
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
}
