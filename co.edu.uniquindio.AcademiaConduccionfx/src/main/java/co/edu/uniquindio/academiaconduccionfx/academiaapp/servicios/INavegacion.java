package co.edu.uniquindio.academiaconduccionfx.academiaapp.servicios;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.AcademiaApplication;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller.LoginViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public interface INavegacion {
    default void irPantalla(String fxmlPath, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(AcademiaApplication.class.getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
