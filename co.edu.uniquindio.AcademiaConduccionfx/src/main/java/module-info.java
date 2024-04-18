module co.edu.uniquindio.academiaconduccionfx.academiaapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.security.jgss;


    opens co.edu.uniquindio.academiaconduccionfx.academiaapp to javafx.fxml;
    exports co.edu.uniquindio.academiaconduccionfx.academiaapp;

    opens co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller;
    exports co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller;

    opens co.edu.uniquindio.academiaconduccionfx.academiaapp.controller;
    exports co.edu.uniquindio.academiaconduccionfx.academiaapp.controller;
}