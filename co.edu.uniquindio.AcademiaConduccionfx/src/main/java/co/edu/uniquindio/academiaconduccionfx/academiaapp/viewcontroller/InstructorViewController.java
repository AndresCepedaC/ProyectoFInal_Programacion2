package co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.controller.InstructorController;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.controller.UsuarioController;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Instructor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class InstructorViewController {
    InstructorController instructorController;
    ObservableList<Instructor> listaInstructores = FXCollections.observableArrayList();
    Instructor instructorSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton rBtnMayorQue;

    @FXML
    private Button btnObtenerLetra;
    @FXML
    private RadioButton rBtnMenorQue;
    @FXML
    private TextField txtObtenerLetra;
    @FXML
    private TextField txtObtenerEdad;
    @FXML
    private ToggleGroup group1;
    @FXML
    private Button btnObtenerXEdad;
    @FXML
    private TextField txtPassword;
    @FXML
    private TableView<Instructor> tableInstructor;

    @FXML
    private TableColumn<Usuario, String> tcApellido;

    @FXML
    private TableColumn<Usuario, String> tcCedula;

    @FXML
    private TableColumn<Usuario, String> tcCorreo;

    @FXML
    private TableColumn<Usuario,String > tcEdad;

    @FXML
    private TableColumn<Usuario, String> tcNombre;

    @FXML
    private TextField txtapellido;

    @FXML
    private TextField txtcedula;

    @FXML
    private TextField txtcorreo;

    @FXML
    private TextField txtedad;
    @FXML
    TextField campoTexto;
    @FXML
    private TextField txtnombre;
    @FXML
    private Button btnLimpiarCampos;

    @FXML
    private Button btnActualizar;

    @FXML
    void onLimpiarCampos(ActionEvent event) {
        limpiarCampos();
        mostrarMensaje("Notificacion Instructor", "Campos vacios", "Campos vacios", Alert.AlertType.CONFIRMATION);

    }


    @FXML
    void onAgregar(ActionEvent event) {
        crearInstructor();
    }

    @FXML
    void onActualizar(ActionEvent event) {
        actualizarInstructor();
    }

    @FXML
    void onEliminar(ActionEvent event) {
        eliminarInstructor();
    }
    @FXML
    void onObtenerXEdad(ActionEvent event) {
        obtenerPorEdad();
    }
    @FXML
    void obObtenerLetra(ActionEvent event) {
        obtenerPorLetra();
    }
    @FXML
    void initialize() {
        instructorController = new InstructorController();
        initView();
        actualizarCampo();
    }

    private void initView() {
        initDataBinding();
        obtenerInstructores();
        tableInstructor.getItems().clear();
        tableInstructor.setItems(listaInstructores);
        listenerselection();
        limpiarCampos();
    }

    private void listenerselection() {
        tableInstructor.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            instructorSeleccionado = newSelection;
            mostrarInformacionInstructor(instructorSeleccionado);

        });
    }

    private void mostrarInformacionInstructor(Instructor instructorSeleccionado) {
        if(instructorSeleccionado != null){
            txtnombre.setText(instructorSeleccionado.getNombre());
            txtapellido.setText(instructorSeleccionado.getApellido());
            txtcedula.setText(instructorSeleccionado.getCedula());
            txtedad.setText(String.valueOf(instructorSeleccionado.getEdad()));
            txtcorreo.setText(instructorSeleccionado.getCorreo());
        }
    }


    private void obtenerInstructores() {
        listaInstructores.addAll(instructorController.obtenerInstructores());
    }


    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
        tcCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
    }
    private void crearInstructor(){
        if (validadFormulario()){
            Instructor instructorNuevo = construirDatosInstructor();
            if (instructorController.crearInstructor(instructorNuevo)) {
                listaInstructores.add(instructorNuevo);
                mostrarMensaje("Notificación instructor", "Instructor creado", "El instructor se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }else {
                mostrarMensaje("Notificación instructor", "Instructor no creado ", "El instructor se ha creado sin éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }
        }else {
            mostrarMensaje("Notificación instructor", "Campos de texto invalidos", "El instructor se ha creado sin éxito, por favor ingrese los datos correctamente", Alert.AlertType.ERROR);
        }
    }
    private void actualizarInstructor(){
        if (validadFormulario()){
            Instructor instructorEncontrado = obtenerInstructor(txtcedula.getText());
            Instructor instructorNuevo = construirDatosInstructor();
            if (instructorEncontrado != null){
                int index = encontrarIndiceInstructor(instructorEncontrado) - 1;
                listaInstructores.set(index, instructorNuevo);
                mostrarMensaje("Notificación instructor", "Instructor actualizado", "El instructor se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }else {
                mostrarMensaje("Notificación instructor", "Instructor no existe ", "El instructor no existe", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }
        }else {
            mostrarMensaje("Notificación instructor", "Campos de texto invalidos", "El instructor se ha creado sin éxito, por favor ingrese los datos correctamente", Alert.AlertType.ERROR);
        }
    }
    private void actualizarTabla() {
        TextField campoTexto = new TextField();
        campoTexto.setPromptText("Escribe aquí para filtrar");
        campoTexto.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<Instructor> clientesFiltrados = FXCollections.observableArrayList();
            for (Instructor instructor : listaInstructores) {
                if (instructor.getNombre().toLowerCase().contains(newValue.toLowerCase())) {
                    clientesFiltrados.add(instructor);
                }
            }
            tableInstructor.setItems(clientesFiltrados);
        });
    }
    private void actualizarCampo() {
        tableInstructor.setItems(listaInstructores);

        campoTexto.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<Instructor> clientesFiltrados = FXCollections.observableArrayList();
            for (Instructor instructor : listaInstructores) {
                if (instructor.getNombre().toLowerCase().contains(newValue.toLowerCase()) || instructor.getApellido().toLowerCase().contains(newValue.toLowerCase()) || String.valueOf( instructor.getEdad()).toLowerCase().contains(newValue.toLowerCase())) {
                    clientesFiltrados.add(instructor);
                }
            }
            tableInstructor.setItems(clientesFiltrados);
        });
    }
    private void eliminarInstructor(){
        if (!txtcedula.getText().isEmpty()){
            Instructor instructor = obtenerInstructor(txtcedula.getText());
            if (instructor != null){
                listaInstructores.remove(instructor);
                mostrarMensaje("Notificacion instructor", "Instructor eliminado", "El instructor se ha eliminado con exito", Alert.AlertType.INFORMATION);
            }else {
                mostrarMensaje("Notificacion instructor", "Instructor no existe", "El instructor no existe", Alert.AlertType.WARNING);
            }
        }else {
            mostrarMensaje("Notificacion instructor", "Campos vacios", "Ingrese los datos del instructor", Alert.AlertType.ERROR);

        }
    }

    private Instructor obtenerInstructor(String cedula) {
        return  instructorController.obtenerInstructor(cedula);
    }

    private void limpiarCampos() {
        txtnombre.setText("");
        txtapellido.setText("");
        txtcedula.setText("");
        txtedad.setText("");
        txtcorreo.setText("");
        txtPassword.setText("");
    }
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
    private boolean validadFormulario(){
        if (txtnombre.getText().isEmpty()){
            return false;
        } else if (txtapellido.getText().isEmpty()) {
            return false;
        }else if (txtedad.getText().isEmpty()) {
            return false;
        }else if (txtcedula.getText().isEmpty()) {
            return false;
        }else if (txtcorreo.getText().isEmpty()) {
            return false;
        }
        else if (txtPassword.getText().isEmpty()) {
            return false;
        }
        return true;
    }
    private Instructor construirDatosInstructor(){
        return Instructor.builder()
                .setNombre(txtnombre.getText())
                .setEdad(Integer.parseInt( txtedad.getText()))
                .setCorreo(txtcorreo.getText())
                .setCedula(txtcedula.getText())
                .setApellido(txtapellido.getText())
                .setPassword(txtPassword.getText())
                .build();
    }
    private void obtenerPorEdad() {
        ObservableList<Instructor> instructoresFiltrados = FXCollections.observableArrayList();
        int edadIngresada;

        try {
            edadIngresada = Integer.parseInt(txtObtenerEdad.getText());
        } catch (NumberFormatException e) {
            mostrarMensaje("Campo de texto inválido", "Error", "Por favor, verifica el campo de texto.", Alert.AlertType.ERROR);
            return;
        }

        if (rBtnMayorQue.isSelected()) {
            for (Instructor instructor : listaInstructores) {
                if (instructor.getEdad() > edadIngresada) {
                    instructoresFiltrados.add(instructor);
                }
            }
        } else {
            for (Instructor instructor : listaInstructores) {
                if (instructor.getEdad() <= edadIngresada) {
                    instructoresFiltrados.add(instructor);
                }
            }
        }

        tableInstructor.setItems(instructoresFiltrados);
    }




    private void obtenerPorLetra() {
        ObservableList<Instructor> instructoresFiltrados = FXCollections.observableArrayList();
        Character letra = txtObtenerLetra.getText().toLowerCase().charAt(0);

        for (Instructor instructor : listaInstructores) {
            if (instructor.getNombre().toLowerCase().charAt(0) == Character.toLowerCase(letra)){
                instructoresFiltrados.add(instructor);
            }
        }

        tableInstructor.setItems(instructoresFiltrados);
    }
    private int encontrarIndiceInstructor(Instructor cedula){
        return instructorController.encontrarIndiceInstructor(cedula);
    }
}
