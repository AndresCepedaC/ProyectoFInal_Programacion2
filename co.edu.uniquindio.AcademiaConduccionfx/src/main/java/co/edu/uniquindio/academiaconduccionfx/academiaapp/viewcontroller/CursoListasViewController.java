package co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.controller.CursoListasContoller;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Curso;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Inscripcion;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Instructor;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.servicios.INavegacion;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CursoListasViewController implements INavegacion {
    CursoListasContoller controller;
    ObservableList<Instructor> listaInstructoresAsociados = FXCollections.observableArrayList();
    ObservableList<Inscripcion> listaInscripcionesAsociadas = FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarInscripcion;
    @FXML
    private Button btnActualizarCurso;

    @FXML
    private TableColumn<Inscripcion, String> tcCategoria;

    @FXML
    private TableColumn<Instructor, String> tcApellido;

    @FXML
    private TableView<?> tableCursosAsociadosInscripcion;

    @FXML
    private TableColumn<Inscripcion, String> tcUsuarioAsociado;

    @FXML
    private TableColumn<Instructor, String> tcCorreo;

    @FXML
    private TableColumn<Curso, String> tcIDCursoAsociadoInscripcion;

    @FXML
    private TableColumn<Instructor, String> tcCedula;

    @FXML
    private TextField txtCedulaInstructorAsociado;

    @FXML
    private TableView<Instructor> tableInstructoresAsociados;

    @FXML
    private TableColumn<Instructor, String> tcEdad;

    @FXML
    private Button btnAgregarInstructor;

    @FXML
    private TableView<Instructor> tableIntructoresAsociadosInscripcion;

    @FXML
    private Button btnCancelar;

    @FXML
    private TableColumn<Instructor, String> tcCorreoInstructorAsociado;

    @FXML
    private TextField txtIDInscripcion;

    @FXML
    private TableColumn<Instructor, String> tcNombreinstructorAsociado;

    @FXML
    private TableColumn<Instructor, String> tcEdadInstructorAsociado;

    @FXML
    private TableView<Inscripcion> tableInscripcionAsociada;

    @FXML
    private TableColumn<Curso, String> tcIDCursoAsociadoInstructor;

    @FXML
    private TableColumn<Instructor, String> tcNombre;

    @FXML
    private TableColumn<Inscripcion, String> tcNumero;

    @FXML
    private TableColumn<Inscripcion, String> tcFechaInscripcion;

    @FXML
    private TableColumn<Instructor, String> tcCedulaInstructorAsociado;

    @FXML
    private TableColumn<Curso, String> tcDescripcionCursoAsociadoInscripcion;

    @FXML
    private TableView<Curso> tableCursosAsociadosInstructor;

    @FXML
    private Button btnCrearCurso;

    @FXML
    private TableColumn<Curso, String> tcDescripcionCursoInstructorAsociado;

    @FXML
    private TableColumn<Inscripcion, String> tcIDInscripcion;
    @FXML
    void onActualizarCurso(ActionEvent event) {
        actualizarCurso();
    }
    @FXML
    void onAgregarInscripcion(ActionEvent event) {
        agregarInscripcion();
    }

    @FXML
    void onAgregarInstructor(ActionEvent event) {
        agregarInstructor();
    }

    @FXML
    void onCrearCurso(ActionEvent event) {
        crearCurso();
    }

    @FXML
    void onCancelar(ActionEvent event) {
        cerrarVista();
    }

    @FXML
    void initialize() {
        controller = new CursoListasContoller();
        initView();
    }

    private void initView() {
        initDataBinding();
        initTables();
        limpiarCampos();
    }

    private void initDataBinding() {
        initTables();
        initTableInscripcion();
        initTableInstructor();
    }
    private void initTableInscripcion() {
        initTableInscripcion2();
        initTableCursoAsociadoInscripcion();
        initTableInstructorAsociadoInscripcion();
    }

    private void initTables() {
        initTableInscripcion();
        initTableInstructor();
        initTableCursoAsociadoInstructor();
    }
    private void initTableCursoAsociadoInstructor() {
        tcIDCursoAsociadoInstructor.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdCurso())));
        tcDescripcionCursoInstructorAsociado.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDescripcion())));
    }
    private void initTableInstructor() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNombre())));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCedula())));
        tcCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCorreo())));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getApellido())));
    }
    private void initTableInscripcion2() {
        tcNumero.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNumeroInscripcion())));
        tcCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCategoriaLicencia())));
        tcIDInscripcion.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEstado())));
        tcUsuarioAsociado.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getUsuario().getCedula())));
        tcFechaInscripcion.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getFechaInscripcion())));
    }
    private void initTableInstructorAsociadoInscripcion() {
        tcNombreinstructorAsociado.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNombre())));
        tcEdadInstructorAsociado.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
        tcCedulaInstructorAsociado.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCedula())));
        tcCorreoInstructorAsociado.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCorreo())));
    }
    private void initTableCursoAsociadoInscripcion() {
        tcIDCursoAsociadoInscripcion.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdCurso())));
        tcDescripcionCursoAsociadoInscripcion.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDescripcion())));
    }
    private void agregarInscripcion() {
        if (!txtIDInscripcion.getText().isEmpty()){
            Inscripcion inscripcion = controller.obtenerInscripcion(txtIDInscripcion.getText());
            agregarInscripcionTabla(inscripcion);
        }
    }
    private void agregarInstructor() {
        if (!txtCedulaInstructorAsociado.getText().isEmpty()){
            Instructor instructor = controller.obtenerInstructor(txtCedulaInstructorAsociado.getText());
            agregarInstructorTabla(instructor);
        }
    }

    private void agregarInstructorTabla(Instructor instructor) {
        listaInstructoresAsociados.add(instructor);
        tableInstructoresAsociados.setItems(listaInstructoresAsociados);
    }

    private void agregarInscripcionTabla(Inscripcion inscripcion) {
        listaInscripcionesAsociadas.add(inscripcion);
        tableInscripcionAsociada.setItems(listaInscripcionesAsociadas);
    }
    private void actualizarCurso() {

    }
    private void cerrarVista() {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    private void crearCurso() {
    }
    private void limpiarCampos() {
        txtIDInscripcion.setText("");
        txtCedulaInstructorAsociado.setText("");
    }
}
