package co.edu.uniquindio.academiaconduccionfx.academiaapp.viewcontroller;

import co.edu.uniquindio.academiaconduccionfx.academiaapp.controller.UsuarioController;
import co.edu.uniquindio.academiaconduccionfx.academiaapp.model.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class UsuarioViewController {
    UsuarioController usuarioController;
    ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    Usuario usuarioSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Usuario> tableUsuario;

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
    private TextField txtnombre;
    @FXML
    private Button btnLimpiarCampos;

    @FXML
    private Button btnActualizar;

    @FXML
    void onLimpiarCampos(ActionEvent event) {
        limpiarCampos();
        mostrarMensaje("Notificacion Usuario", "Campos vacios", "Campos vacios", Alert.AlertType.CONFIRMATION);

    }

    
    @FXML
    void onAgregar(ActionEvent event) {
        crearUsuario();
    }

    @FXML
    void onActualizar(ActionEvent event) {
        actualizarUsuario();
    }

    @FXML
    void onEliminar(ActionEvent event) {
        eliminarUsuario();
    }

    @FXML
    void initialize() {
        usuarioController = new UsuarioController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerUsuarios();
        tableUsuario.getItems().clear();
        tableUsuario.setItems(listaUsuarios);
        listenerselection();
    }

    private void listenerselection() {
        tableUsuario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            usuarioSeleccionado = newSelection;
            mostrarInformacionUsuario(usuarioSeleccionado);

        });
    }

    private void mostrarInformacionUsuario(Usuario usuarioSeleccionado) {
        if(usuarioSeleccionado != null){
            txtnombre.setText(usuarioSeleccionado.getNombre());
            txtapellido.setText(usuarioSeleccionado.getApellido());
            txtcedula.setText(usuarioSeleccionado.getCedula());
            txtedad.setText(String.valueOf(usuarioSeleccionado.getEdad()));
            txtcorreo.setText(usuarioSeleccionado.getCorreo());
        }
    }

    private void obtenerUsuarios() {
        listaUsuarios.addAll(usuarioController.obtenerUsuarios());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
        tcCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
    }
    private void crearUsuario(){
        if (validadFormulario()){
            Usuario usuarioNuevo = construirDatosUsuario();
            if (usuarioController.crearUsuario(usuarioNuevo)) {
                listaUsuarios.add(usuarioNuevo);
                mostrarMensaje("Notificación Usuario", "Usuario creado", "El usuario se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }else {
                mostrarMensaje("Notificación usuario", "Usuario no creado ", "El usuario se ha creado sin éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }
        }else {
            mostrarMensaje("Notificación cliente", "Campos de texto invalidos", "El cliente se ha creado sin éxito, por favor ingrese los datos correctamente", Alert.AlertType.ERROR);
        }
    }
    private void actualizarUsuario(){
        if (validadFormulario()){
            Usuario usuarioEncontrado = obtenerUsuario(txtcedula.getText());
            Usuario usuarioNuevo = construirDatosUsuario();
            if (usuarioEncontrado != null){
                int index = encontrarIndiceUsuario(usuarioEncontrado) - 1;
                listaUsuarios.set(index, usuarioNuevo);
                mostrarMensaje("Notificación Usuario", "Usuario actualizado", "El usuario se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }else {
                mostrarMensaje("Notificación usuario", "Usuario no existe ", "El usuario no existe", Alert.AlertType.INFORMATION);
                limpiarCampos();
            }
        }else {
            mostrarMensaje("Notificación cliente", "Campos de texto invalidos", "El cliente se ha creado sin éxito, por favor ingrese los datos correctamente", Alert.AlertType.ERROR);
        }
    }

    private void eliminarUsuario(){
        if (!txtcedula.getText().isEmpty()){
            Usuario usuario = obtenerUsuario(txtcedula.getText());
            if (usuario != null){
                listaUsuarios.remove(usuario);
                mostrarMensaje("Notificacion Usuario", "Usuario eliminado", "El usuario se ha eliminado con exito", Alert.AlertType.INFORMATION);
            }else {
                mostrarMensaje("Notificacion Usuario", "Usuario no existe", "El usuario no existe", Alert.AlertType.WARNING);
            }
        }else {
            mostrarMensaje("Notificacion Usuario", "Campos vacios", "Ingrese los datos del usuario", Alert.AlertType.ERROR);

        }
    }

    private Usuario obtenerUsuario(String cedula) {
        return  usuarioController.obtenerUsuario(cedula);
    }

    private void limpiarCampos() {
        txtnombre.setText("");
        txtapellido.setText("");
        txtcedula.setText("");
        txtedad.setText("");
        txtcorreo.setText("");
    }
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
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
        return true;
    }
    private Usuario construirDatosUsuario(){
        return Usuario.builder()
                .setNombre(txtnombre.getText())
                .setEdad(Integer.parseInt( txtedad.getText()))
                .setCorreo(txtcorreo.getText())
                .setCedula(txtcedula.getText())
                .setApellido(txtapellido.getText())
                .build();
    }
    private int encontrarIndiceUsuario(Usuario cedula){
        return usuarioController.encontrarIndiceUsuario(cedula);
    }
}
