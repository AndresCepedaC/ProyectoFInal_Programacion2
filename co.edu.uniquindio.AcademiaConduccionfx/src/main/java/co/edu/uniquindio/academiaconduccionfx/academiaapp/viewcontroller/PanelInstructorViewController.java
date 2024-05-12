package co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Sesion;
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
        cerrarSesion("Login/Login.fxml", "Bienvenida", btnCerrarSesion);
    }
}
