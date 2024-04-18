package co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.controller.RegisterController;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.factory.ModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    }

    @FXML
    void initialize() {
        registerController = new RegisterController();
    }
}
