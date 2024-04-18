package co.edu.uniquindio.academiaconduccionfx.academiaapp.servicios;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.AcademiaApplication;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller.LoginViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public interface INavegacion {
    default void irPantalla(String nombreArchivoFxml, String tituloVentana) {
        try {
            FXMLLoader loader = new FXMLLoader(AcademiaApplication.class.getResource(nombreArchivoFxml));
            Parent parent = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle(tituloVentana);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
