package co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.servicios.INavegacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PanelInstructorViewController implements INavegacion {

    @FXML
    private Button btnCerrarSesion;

    @FXML
    void onCerrarSesion(ActionEvent event) {

        cerrarSesion();
    }

    private void cerrarSesion() {
        irPantalla("Login/Login.fxml", "Bienvenida");
        Stage stage = (Stage) btnCerrarSesion.getScene().getWindow();
        stage.close();
    }
}
