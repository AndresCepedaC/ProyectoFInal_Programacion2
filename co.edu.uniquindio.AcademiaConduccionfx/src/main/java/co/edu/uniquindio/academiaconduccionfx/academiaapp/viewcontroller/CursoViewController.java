package co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.controller.CursoController;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Curso;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.dto.CursoDTO;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.servicios.INavegacion;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CursoViewController implements INavegacion {
    private Curso cursoContinuar;
    ObservableList<Curso> listaCursos = FXCollections.observableArrayList();
    Curso cursoSeleccionado;
    CursoController controlador;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Curso, String> tcFechaInicio;

    @FXML
    private TableView<Curso> tableCursos;

    @FXML
    private Button btnContinuarCreando;

    @FXML
    private TableColumn<Curso, String> tcDuracion;

    @FXML
    private TableColumn<Curso, String> tcFechaFin;

    @FXML
    private TableColumn<Curso, String> tcCapacidad;

    @FXML
    private TextField txtDescripcionCurso;

    @FXML
    private Button btnActualizarCurso;

    @FXML
    private TextField txtIDCurso;

    @FXML
    private TextField txtFechaFin;

    @FXML
    private TextField txtDuracion;

    @FXML
    private TableColumn<Curso, String> tcCosto;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizarListaCurso;

    @FXML
    private TableColumn<Curso, String> tcDescripcion;

    @FXML
    private TextField txtCosto;

    @FXML
    private TextField txtFechaInicio;

    @FXML
    private TextField txtCapacidad;

    @FXML
    private TableColumn<Curso, String> tcIDCurso;
    @FXML
    void onContinuarCreando(ActionEvent event) {
        if (!txtCapacidad.getText().isEmpty() ||
                !txtCosto.getText().isEmpty() ||
                !txtFechaFin.getText().isEmpty() ||
                !txtFechaInicio.getText().isEmpty() ||
                !txtDuracion.getText().isEmpty() ||
                !txtIDCurso.getText().isEmpty() ||
                !txtDescripcionCurso.getText().isEmpty()) {
            crearCurso();
            irPantalla("model/CursoListas.fxml", "Crear Cursos");
        }else {
            mostrarMensaje("Notificacion Cursos", "Campos vacios", "Campos vacios", Alert.AlertType.WARNING);
        }
    }
    @FXML
    void onActualizarCurso(ActionEvent event) {
        if (!txtCapacidad.getText().isEmpty() ||
                !txtCosto.getText().isEmpty() ||
                !txtFechaFin.getText().isEmpty() ||
                !txtFechaInicio.getText().isEmpty() ||
                !txtDuracion.getText().isEmpty() ||
                !txtIDCurso.getText().isEmpty() ||
                !txtDescripcionCurso.getText().isEmpty()) {
            crearCurso();
            irPantalla("model/CursoListas.fxml", "Crear Cursos");
        }else {
            mostrarMensaje("Notificacion Cursos", "Campos vacios", "Campos vacios", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void onEliminar(ActionEvent event) {
        eliminarCurso();
    }

    @FXML
    void onActualizarListaCurso(ActionEvent event) throws IOException {
        if (!txtCapacidad.getText().isEmpty() ||
                !txtCosto.getText().isEmpty() ||
                !txtFechaFin.getText().isEmpty() ||
                !txtFechaInicio.getText().isEmpty() ||
                !txtDuracion.getText().isEmpty() ||
                !txtIDCurso.getText().isEmpty() ||
                !txtDescripcionCurso.getText().isEmpty()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("model/CursoListas.fxml"));
            Parent root = loader.load();
            Curso curso = controlador.obtenerCurso(txtIDCurso.getText());
            cursoContinuar = curso;
            CursoListasViewController controller = loader.getController();
            controller.inicializarInstance(this);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Actualizar Cursos");
            stage.show();
        }else {
            mostrarMensaje("Notificacion Cursos", "Campos vacios", "Campos vacios", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void initialize() {
        controlador = new CursoController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerCursos();
        tableCursos.getItems().clear();
        tableCursos.setItems(listaCursos);
        listenerselection();
        limpiarCampos();
    }

    private void initDataBinding() {
        tcIDCurso.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdCurso()));
        tcCapacidad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(  cellData.getValue().getCapacidad())));
        tcCosto.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf( cellData.getValue().getCosto())));
        tcDuracion.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf( cellData.getValue().getDuracion())));
        tcFechaInicio.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf( cellData.getValue().getFechaInicio())));
        tcFechaFin.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf( cellData.getValue().getFechaFin())));
        tcDescripcion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
    }

    private void obtenerCursos() {
        listaCursos.addAll(controlador.obtenerCursos());
    }

    private void listenerselection() {
        tableCursos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            cursoSeleccionado = newSelection;
            mostrarInformacionCurso(cursoSeleccionado);
        });
    }

    private void mostrarInformacionCurso(Curso cursoSeleccionado) {
        if (cursoSeleccionado != null) {
            txtIDCurso.setText(cursoSeleccionado.getIdCurso());
            txtCapacidad.setText(String.valueOf(cursoSeleccionado.getCapacidad()));
            txtCosto.setText(String.valueOf(cursoSeleccionado.getCosto()));
            txtDuracion.setText(String.valueOf(cursoSeleccionado.getDuracion()));
            txtFechaFin.setText(String.valueOf(cursoSeleccionado.getFechaFin()));
            txtFechaInicio.setText(String.valueOf(cursoSeleccionado.getFechaInicio()));
            txtDescripcionCurso.setText(cursoSeleccionado.getDescripcion());
        }
    }

    private void mostrarMensaje(String tittle, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(tittle);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
    private void crearCurso() {
        CursoDTO cursoDTO = construirDatosCurso();
        controlador.crearCurso(cursoDTO);
    }

    public CursoDTO construirDatosCurso() {
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.idCurso = txtIDCurso.getText();
        cursoDTO.capacidad = Integer.parseInt(txtCapacidad.getText());
        cursoDTO.costo = Double.parseDouble(txtCosto.getText());
        cursoDTO.duracion = Integer.parseInt(txtDuracion.getText());
        cursoDTO.fechaFin = new Date();
        cursoDTO.fechaInicio = new Date();
        cursoDTO.descripcion = txtDescripcionCurso.getText();
        return cursoDTO;
    }
        private void eliminarCurso() {
        if (controlador.eliminarCurso(txtIDCurso.getText())){
            mostrarMensaje("Notificacion Cursos", "Eliminado", "Eliminado Correctamente", Alert.AlertType.INFORMATION);
        }else {
            mostrarMensaje("Notificacion Cursos", "No Eliminado", "No se ha podido Eliminar", Alert.AlertType.INFORMATION);
        }
    }
    private void limpiarCampos() {
        txtCapacidad.setText("");
        txtCosto.setText("");
        txtDuracion.setText("");
        txtFechaFin.setText("");
        txtFechaInicio.setText("");
        txtIDCurso.setText("");
        txtDescripcionCurso.setText("");
    }
}
