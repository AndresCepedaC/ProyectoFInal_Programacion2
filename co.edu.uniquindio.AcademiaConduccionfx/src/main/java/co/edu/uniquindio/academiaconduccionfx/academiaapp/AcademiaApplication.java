package co.edu.uniquindio.academiaconduccionfx.academiaapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AcademiaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AcademiaApplication.class.getResource("Bienvenida.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("App Academia de Conduccion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}