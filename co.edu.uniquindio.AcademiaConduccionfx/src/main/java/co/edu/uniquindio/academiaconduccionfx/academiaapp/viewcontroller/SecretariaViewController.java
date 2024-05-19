package co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.controller.SecretariaController;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.controller.UsuarioController;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.Usuario;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.personas.empleados.Secretaria;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SecretariaViewController {
    SecretariaController secretariaController;
    ObservableList<Secretaria> listaSecretarias = FXCollections.observableArrayList();
    Secretaria secretariaSeleccionado;

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
    private TableView<Secretaria> tableSecretaria;

    @FXML
    private TableColumn<Secretaria, String> tcApellido;

    @FXML
    private TableColumn<Secretaria, String> tcCedula;

    @FXML
    private TableColumn<Secretaria, String> tcCorreo;

    @FXML
    private TableColumn<Secretaria,String > tcEdad;

    @FXML
    private TableColumn<Secretaria, String> tcNombre;

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
        mostrarMensaje("Notificacion secretaria", "Campos vacios", "Campos vacios", Alert.AlertType.CONFIRMATION);

    }


    @FXML
    void onAgregar(ActionEvent event) {
        crearSecretaria();
    }

    @FXML
    void onActualizar(ActionEvent event) {
        actualizarSecretaria();
    }

    @FXML
    void onEliminar(ActionEvent event) {
        eliminarSecretaria();
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
        secretariaController = new SecretariaController();
        initView();
        actualizarCampo();
    }

    private void initView() {
        initDataBinding();
        obtenerSecretarias();
        tableSecretaria.getItems().clear();
        tableSecretaria.setItems(listaSecretarias);
        listenerselection();
        limpiarCampos();
    }

    private void listenerselection() {
        tableSecretaria.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            secretariaSeleccionado = newSelection;
            mostrarInformacionSecretaria(secretariaSeleccionado);

        });
    }

    private void mostrarInformacionSecretaria(Secretaria secretariaSeleccionado) {
        if(secretariaSeleccionado != null){
            txtnombre.setText(secretariaSeleccionado.getNombre());
            txtapellido.setText(secretariaSeleccionado.getApellido());
            txtcedula.setText(secretariaSeleccionado.getCedula());
            txtedad.setText(String.valueOf(secretariaSeleccionado.getEdad()));
            txtcorreo.setText(secretariaSeleccionado.getCorreo());
        }
    }

    private void obtenerSecretarias() {
        listaSecretarias.addAll(secretariaController.obtenerSecretarias());
    }


    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
        tcCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
    }
    private void crearSecretaria(){
        if (validadFormulario()){
            Secretaria secretariaNuevo = construirDatosSecretaria();
            if (secretariaController.crearSecretaria(secretariaNuevo)) {
                listaSecretarias.add(secretariaNuevo);
                mostrarMensaje("Notificación secretaria", "Secretaria creada", "La secretaria se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }else {
                mostrarMensaje("Notificación secretaria", "Secretaria no creada ", "La secretaria se ha creado sin éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }
        }else {
            mostrarMensaje("Notificación cliente", "Campos de texto invalidos", "El cliente se ha creado sin éxito, por favor ingrese los datos correctamente", Alert.AlertType.ERROR);
        }
    }
    private void actualizarSecretaria(){
        if (validadFormulario()){
            Secretaria secretariaEncontrado = obtenerSecretaria(txtcedula.getText());
            Secretaria secretariaNuevo = construirDatosSecretaria();
            if (secretariaEncontrado != null){
                int index = encontrarIndiceSecretaria(secretariaEncontrado) - 1;
                listaSecretarias.set(index, secretariaNuevo);
                mostrarMensaje("Notificación secretaria", "Secretaria actualizada", "La secretaria se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }else {
                mostrarMensaje("Notificación secretaria", "Secretaria no existe ", "La secretaria no existe", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }
        }else {
            mostrarMensaje("Notificación secretaria", "Campos de texto invalidos", "La secretaria se ha creado sin éxito, por favor ingrese los datos correctamente", Alert.AlertType.ERROR);
        }
    }
    private void actualizarTabla() {
        TextField campoTexto = new TextField();
        campoTexto.setPromptText("Escribe aquí para filtrar");
        campoTexto.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<Secretaria> clientesFiltrados = FXCollections.observableArrayList();
            for (Secretaria secretaria : listaSecretarias) {
                if (secretaria.getNombre().toLowerCase().contains(newValue.toLowerCase())) {
                    clientesFiltrados.add(secretaria);
                }
            }
            tableSecretaria.setItems(clientesFiltrados);
        });
    }
    private void actualizarCampo() {
        tableSecretaria.setItems(listaSecretarias);

        campoTexto.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<Secretaria> clientesFiltrados = FXCollections.observableArrayList();
            for (Secretaria secretaria : listaSecretarias) {
                if (secretaria.getNombre().toLowerCase().contains(newValue.toLowerCase()) || secretaria.getApellido().toLowerCase().contains(newValue.toLowerCase()) || String.valueOf( secretaria.getEdad()).toLowerCase().contains(newValue.toLowerCase())) {
                    clientesFiltrados.add(secretaria);
                }
            }
            tableSecretaria.setItems(clientesFiltrados);
        });
    }
    private void eliminarSecretaria(){
        if (!txtcedula.getText().isEmpty()){
            Secretaria secretaria = obtenerSecretaria(txtcedula.getText());
            if (secretaria != null){
                listaSecretarias.remove(secretaria);
                mostrarMensaje("Notificacion secretaria", "Secretaria eliminada", "La secretaria se ha eliminado con exito", Alert.AlertType.INFORMATION);
            }else {
                mostrarMensaje("Notificacion secretaria", "Secretaria no existe", "La secretaria no existe", Alert.AlertType.WARNING);
            }
        }else {
            mostrarMensaje("Notificacion secretaria", "Campos vacios", "Ingrese los datos de la secretaria", Alert.AlertType.ERROR);

        }
    }

    private Secretaria obtenerSecretaria(String cedula) {
        return  secretariaController.obtenerSecretaria(cedula);
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
    private Secretaria construirDatosSecretaria(){
        return Secretaria.builder()
                .setNombre(txtnombre.getText())
                .setEdad(Integer.parseInt( txtedad.getText()))
                .setCorreo(txtcorreo.getText())
                .setCedula(txtcedula.getText())
                .setApellido(txtapellido.getText())
                .setPassword(txtPassword.getText())
                .build();
    }
    private void obtenerPorEdad() {
        ObservableList<Secretaria> secretariasFiltrados = FXCollections.observableArrayList();
        int edadIngresada;

        try {
            edadIngresada = Integer.parseInt(txtObtenerEdad.getText());
        } catch (NumberFormatException e) {
            mostrarMensaje("Campo de texto inválido", "Error", "Por favor, verifica el campo de texto.", Alert.AlertType.ERROR);
            return;
        }

        if (rBtnMayorQue.isSelected()) {
            for (Secretaria secretaria : listaSecretarias) {
                if (secretaria.getEdad() > edadIngresada) {
                    secretariasFiltrados.add(secretaria);
                }
            }
        } else {
            for (Secretaria secretaria : listaSecretarias) {
                if (secretaria.getEdad() <= edadIngresada) {
                    secretariasFiltrados.add(secretaria);
                }
            }
        }

        tableSecretaria.setItems(secretariasFiltrados);
    }




    private void obtenerPorLetra() {
        ObservableList<Secretaria> secretariasFiltrados = FXCollections.observableArrayList();
        Character letra = txtObtenerLetra.getText().toLowerCase().charAt(0);

        for (Secretaria secretaria : listaSecretarias) {
            if (secretaria.getNombre().toLowerCase().charAt(0) == Character.toLowerCase(letra)){
                secretariasFiltrados.add(secretaria);
            }
        }

        tableSecretaria.setItems(secretariasFiltrados);
    }
    private int encontrarIndiceSecretaria(Secretaria cedula){
        return secretariaController.encontrarIndiceSecretaria(cedula);
    }
}
