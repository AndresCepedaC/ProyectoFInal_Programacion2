package co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.controller.AdministradorController;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Administrador;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AdmistradorViewController {
    AdministradorController administradorController;
    ObservableList<Administrador> listaAdministradores = FXCollections.observableArrayList();
    Administrador administradorSeleccionado;

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
    private TableView<Administrador> tableAdministrador;

    @FXML
    private TableColumn<Administrador, String> tcApellido;

    @FXML
    private TableColumn<Administrador, String> tcCedula;

    @FXML
    private TableColumn<Administrador, String> tcCorreo;

    @FXML
    private TableColumn<Administrador,String > tcEdad;

    @FXML
    private TableColumn<Administrador, String> tcNombre;

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
        mostrarMensaje("Notificacion Administrador", "Campos vacios", "Campos vacios", Alert.AlertType.CONFIRMATION);

    }


    @FXML
    void onAgregar(ActionEvent event) {
        crearAdministrador();
    }

    @FXML
    void onActualizar(ActionEvent event) {
        actualizarAdministrador();
    }

    @FXML
    void onEliminar(ActionEvent event) {
        eliminarAdministrador();
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
        administradorController = new AdministradorController();
        initView();
        actualizarCampo();
    }

    private void initView() {
        initDataBinding();
        obtenerAdministradores();
        tableAdministrador.getItems().clear();
        tableAdministrador.setItems(listaAdministradores);
        listenerselection();
        limpiarCampos();
    }

    private void listenerselection() {
        tableAdministrador.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            administradorSeleccionado = newSelection;
            mostrarInformacionAdministrador(administradorSeleccionado);

        });
    }

    private void mostrarInformacionAdministrador(Administrador administradorSeleccionado) {
        if(administradorSeleccionado != null){
            txtnombre.setText(administradorSeleccionado.getNombre());
            txtapellido.setText(administradorSeleccionado.getApellido());
            txtcedula.setText(administradorSeleccionado.getCedula());
            txtedad.setText(String.valueOf(administradorSeleccionado.getEdad()));
            txtcorreo.setText(administradorSeleccionado.getCorreo());
        }
    }

    private void obtenerAdministradores() {
        listaAdministradores.addAll(administradorController.obtenerAdministradores());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
        tcCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
    }
    private void crearAdministrador(){
        if (validadFormulario()){
            Administrador administradorNuevo = construirDatosAdministrador();
            if (administradorController.crearAdministrador(administradorNuevo)) {
                listaAdministradores.add(administradorNuevo);
                mostrarMensaje("Notificación administrador", "Administrador creado", "El administrador se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }else {
                mostrarMensaje("Notificación administrador", "Administrador no creado ", "El administrador se ha creado sin éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }
        }else {
            mostrarMensaje("Notificación administrador", "Campos de texto invalidos", "El administrador se ha creado sin éxito, por favor ingrese los datos correctamente", Alert.AlertType.ERROR);
        }
    }
    private void actualizarAdministrador(){
        if (validadFormulario()){
            Administrador administradorEncontrado = obtenerAdministrador(txtcedula.getText());
            Administrador administradorNuevo = construirDatosAdministrador();
            if (administradorEncontrado != null){
                int index = encontrarIndiceAdministrador(administradorEncontrado) - 1;
                listaAdministradores.set(index, administradorNuevo);
                mostrarMensaje("Notificación Administrador", "Administrador actualizado", "El administrador se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }else {
                mostrarMensaje("Notificación administrador", "Administrador no existe ", "El administrador no existe", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }
        }else {
            mostrarMensaje("Notificación administrador", "Campos de texto invalidos", "El administrador se ha creado sin éxito, por favor ingrese los datos correctamente", Alert.AlertType.ERROR);
        }
    }
    private void actualizarTabla() {
        TextField campoTexto = new TextField();
        campoTexto.setPromptText("Escribe aquí para filtrar");
        campoTexto.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<Administrador> administradoresFiltrados = FXCollections.observableArrayList();
            for (Administrador administrador : listaAdministradores) {
                if (administrador.getNombre().toLowerCase().contains(newValue.toLowerCase())) {
                    administradoresFiltrados.add(administrador);
                }
            }
            tableAdministrador.setItems(administradoresFiltrados);
        });
    }
    private void actualizarCampo() {
        tableAdministrador.setItems(listaAdministradores);

        campoTexto.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<Administrador> clientesFiltrados = FXCollections.observableArrayList();
            for (Administrador administrador : listaAdministradores) {
                if (administrador.getNombre().toLowerCase().contains(newValue.toLowerCase()) || administrador.getApellido().toLowerCase().contains(newValue.toLowerCase()) || String.valueOf( administrador.getEdad()).toLowerCase().contains(newValue.toLowerCase())) {
                    clientesFiltrados.add(administrador);
                }
            }
            tableAdministrador.setItems(clientesFiltrados);
        });
    }
    private void eliminarAdministrador(){
        if (!txtcedula.getText().isEmpty()){
            Administrador administrador = obtenerAdministrador(txtcedula.getText());
            if (administrador != null){
                listaAdministradores.remove(administrador);
                mostrarMensaje("Notificacion Administrador", "Administrador eliminado", "El administrador se ha eliminado con exito", Alert.AlertType.INFORMATION);
            }else {
                mostrarMensaje("Notificacion administrador", "Administrador no existe", "El administrador no existe", Alert.AlertType.WARNING);
            }
        }else {
            mostrarMensaje("Notificacion administrador", "Campos vacios", "Ingrese los datos del administrador", Alert.AlertType.ERROR);

        }
    }

    private Administrador obtenerAdministrador(String cedula) {
        return administradorController.obtenerAdministrador(cedula);
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
    private Administrador construirDatosAdministrador(){
        return Administrador.builder()
                .setNombre(txtnombre.getText())
                .setEdad(Integer.parseInt( txtedad.getText()))
                .setCorreo(txtcorreo.getText())
                .setCedula(txtcedula.getText())
                .setApellido(txtapellido.getText())
                .setPassword(txtPassword.getText())
                .build();
    }
    private void obtenerPorEdad() {
        ObservableList<Administrador> administradoresFiltrados = FXCollections.observableArrayList();
        int edadIngresada;

        try {
            edadIngresada = Integer.parseInt(txtObtenerEdad.getText());
        } catch (NumberFormatException e) {
            mostrarMensaje("Campo de texto inválido", "Error", "Por favor, verifica el campo de texto.", Alert.AlertType.ERROR);
            return;
        }

        if (rBtnMayorQue.isSelected()) {
            for (Administrador administrador : listaAdministradores) {
                if (administrador.getEdad() > edadIngresada) {
                    administradoresFiltrados.add(administrador);
                }
            }
        } else {
            for (Administrador administrador : listaAdministradores) {
                if (administrador.getEdad() <= edadIngresada) {
                    administradoresFiltrados.add(administrador);
                }
            }
        }

        tableAdministrador.setItems(administradoresFiltrados);
    }




    private void obtenerPorLetra() {
        ObservableList<Administrador> administradoresFiltrados = FXCollections.observableArrayList();
        Character letra = txtObtenerLetra.getText().toLowerCase().charAt(0);

        for (Administrador administrador : listaAdministradores) {
            if (administrador.getNombre().toLowerCase().charAt(0) == Character.toLowerCase(letra)){
                administradoresFiltrados.add(administrador);
            }
        }

        tableAdministrador.setItems(administradoresFiltrados);
    }
    private int encontrarIndiceAdministrador(Administrador cedula){
        return administradorController.encontrarIndiceAdministrador(cedula);
    }
}
