package com.davity.ipa.Controllers;

import com.davity.ipa.App;
import com.davity.ipa.Models.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

public class Empleados implements Initializable {

    @FXML
    private ImageView beneficiario;

    @FXML
    private ImageView inicio;

    @FXML
    private ImageView inventario;

    @FXML
    private ImageView proveedor;

    @FXML
    private ImageView btnAnadirEmpleado;

    @FXML
    private ImageView btnContrasenia;

    @FXML
    private ImageView btnEliminarEmpleado;

    @FXML
    private ImageView btnHombre;

    @FXML
    private ImageView btnModificarDatos;

    @FXML
    private ImageView btnMujer;

    @FXML
    private ImageView btnUsuario;

    @FXML
    private ImageView empleado;

    @FXML
    private Label labelContrasenia;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtid;

    @FXML
    private TableColumn<Empleado, String> genero;

    @FXML
    private TableColumn<Empleado, String> id;

    @FXML
    private TableColumn<Empleado, String> contrasenia;

    @FXML
    private TableColumn<Empleado, String> correo;

    @FXML
    private TableColumn<Empleado, String> nombre;

    @FXML
    private TableColumn<Empleado, String> numero;

    @FXML
    private TableView<Empleado> tablaEmpleados;

    private ObservableList<Empleado> empleados;

    Empleado e = new Empleado("","","","","","");
    String sexo = e.getSexo();
    String password = e.getPassword();

    private ValidationSupport validacion;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        empleados = FXCollections.observableArrayList();
        tablaEmpleados.setItems(empleados);

        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        correo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        numero.setCellValueFactory(new PropertyValueFactory<>("numeroTelefonico"));
        genero.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        contrasenia.setCellValueFactory(new PropertyValueFactory<>("password"));

       validacion = new ValidationSupport();

        Validator<String> nombreValidator = Validator.createEmptyValidator("El nombre  es requerido");
        Validator<String> correoValidator = Validator.createEmptyValidator("el correo es requerido");
        Validator<Integer> numeroValidator = Validator.createEmptyValidator("La numero debe ser un número entero");
        Validator<String> generoValidator = Validator.createEmptyValidator("el genero es requerido");
        Validator<String> idValidator = Validator.createEmptyValidator("el id es requerido");
        Validator<String> contraseniaValidator = Validator.createEmptyValidator("la contraseña es requrida");

      validacion.registerValidator(txtNombre, true, nombreValidator);
      validacion.registerValidator(txtCorreo, true, correoValidator);
      validacion.registerValidator(txtNumero, true, numeroValidator);
      validacion.registerValidator(txtid, true, idValidator);


      txtNumero.textProperty().addListener((observable, oldValue, newValue) -> {

          if (!newValue.matches("\\d*")|| "0".equals(newValue)) {
              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setTitle("Error");
              alert.setHeaderText(null);
              alert.setContentText("Solo puedes ingresar números");
              alert.showAndWait();

              txtNumero.setText(oldValue);
          }
      });

    }

    @FXML
    void OnclickHombre(MouseEvent mouseEventevent) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.WHITE);
        dropShadow.setRadius(10);
        dropShadow.setSpread(0.7); // Extensión del borde iluminado
        btnHombre.setOnMouseClicked(event -> {btnHombre.setEffect(dropShadow);});
        /////////////////// eliminar el color del boton de la mujer porque solo puede elegir 1 genero
        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setColor(Color.GRAY);
        dropShadow2.setRadius(0);
        dropShadow2.setSpread(0);
        btnMujer.setEffect(dropShadow2);
        //////////////////


        sexo = "Hombre";
    }

    @FXML
    void OnclickMujer(MouseEvent mouseEventevent) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.WHITE);
        dropShadow.setRadius(10);
        dropShadow.setSpread(0.7); // Extensión del borde iluminado
        btnMujer.setOnMouseClicked(event -> {btnMujer.setEffect(dropShadow);});
        /////////////////// eliminar el color del boton del hombre porque solo puede elegir 1 genero
        DropShadow dropShadow2 = new DropShadow();
        dropShadow2.setColor(Color.GRAY);
        dropShadow2.setRadius(0);
        dropShadow2.setSpread(0);
        btnHombre.setEffect(dropShadow2);
        //////////////////
        sexo = "Mujer";
    }

    @FXML
    void OnclickAnadirEmpleado(MouseEvent mouseEventevent) {
        String id = this.txtid.getText();
        String password = this.password;
        String name = this.txtNombre.getText();
        String email = this.txtCorreo.getText();
        String numero = this.txtNumero.getText();
        String sexo = this.sexo;

        Empleado empleoyee = new Empleado(id,password,name,email,numero,sexo);

        boolean isValid = true;
        boolean vacio = false;
        String errorMessage = "";


        if (id.isEmpty() || password.isEmpty() || name.isEmpty() || email.isEmpty() || numero.isEmpty() || sexo.isEmpty()) {
            isValid = false;
            errorMessage = "Por favor, complete todos los campos.";
        }


        if (isValid) {
            for (Empleado e : empleados) {
                if (e.getNombre().equals(empleoyee.getNombre()) || e.getNumeroTelefonico().equals(empleoyee.getNumeroTelefonico())
                        || e.getId().equals(empleoyee.getId())) {
                    isValid = false;
                    errorMessage = "Este empleado ya existe";
                    break;
                }
            }
        }
                if (!isValid) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error de validación");
                    alert.setHeaderText(null);
                    alert.setContentText(errorMessage);
                    alert.showAndWait();
            }else{
                    if (!txtCorreo.getText().contains("@") || !txtCorreo.getText().contains(".")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("CORREO INVALIDO");
                        alert.setHeaderText(null);
                        alert.setContentText("El correo es invalido");
                        alert.showAndWait();
                } else {
                    empleados.add(empleoyee);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("AGREGADO");
                    alert.setHeaderText(null);
                    alert.setContentText("Empleado/a agregado/a ✔");
                    alert.showAndWait();

                    // limpiar
                    txtNombre.clear();
                    txtCorreo.clear();
                    txtNumero.clear();
                    txtid.clear();
                    labelContrasenia.setText("");
                }
            }


    }
    @FXML
    void OnclickContrasenia(MouseEvent event) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        password = "";
        Random random = new Random();

        for(int i=0; i<6 ; i++){
            int j = random.nextInt(characters.length());
            password = password + characters.charAt(j);
        }
        labelContrasenia.setText(password);
    }

    @FXML
    void seleccionar(MouseEvent event) {
        Empleado e = this.tablaEmpleados.getSelectionModel().getSelectedItem();

        if(e != null){
            this.txtNombre.setText(e.getNombre());
            this.txtNumero.setText(e.getNumeroTelefonico());
            this.txtid.setText(e.getId());
            this.txtCorreo.setText(e.getCorreo());
            this.labelContrasenia.setText(password);
        }
    }

    @FXML
    void OnclickModificarDatos(MouseEvent event) {
        Empleado e = this.tablaEmpleados.getSelectionModel().getSelectedItem();

        if(e == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor seleccione a un empleado");
            alert.showAndWait();
        }else {

            try {
                String name = this.txtNombre.getText();
                String id = this.txtid.getText();
                String email = this.txtCorreo.getText();
                String number = this.txtNumero.getText();
                String pass = this.password;
                String genero = this.sexo;

                Empleado empleado = new Empleado(id, pass, name, email, number, genero);


                if (!txtCorreo.getText().contains("@") || !txtCorreo.getText().contains(".com")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("CORREO INVALIDO");
                    alert.setHeaderText(null);
                    alert.setContentText("El correo es invalido");
                    alert.showAndWait();
                } else {

                    if (!this.empleados.contains(empleado)) {
                        e.setNombre(empleado.getNombre());
                        e.setCorreo(empleado.getCorreo());
                        e.setNumeroTelefonico(empleado.getNumeroTelefonico());
                        e.setId(empleado.getId());

                        this.tablaEmpleados.refresh();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Modificado");
                        alert.setHeaderText(null);
                        alert.setContentText("Empleado/a modificado/a");
                        alert.showAndWait();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("El empleado existe");
                        alert.showAndWait();
                    }
                }
            }     catch(NumberFormatException a){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Formato incorrecto");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void OnclickEliminarEmpleado(MouseEvent event) {
        Empleado e = this.tablaEmpleados.getSelectionModel().getSelectedItem();
        if(e == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Selecciona a un beneficiario en la tabla");
            alert.showAndWait();
        }else{
            this.empleados.remove(e);
            this.tablaEmpleados.refresh();

        }
    }

    @FXML
    void onKeyNumero(KeyEvent event) {
    if(txtNumero.getText().length() >= 10){
        event.consume();
    }
}

    @FXML
    void OnclickUsuario(MouseEvent event) {

    }

    @FXML
    void onClickBeneficiario(MouseEvent event) {
        App.newStage("Beneficiario","Tabla de beneficiarios");
    }

    @FXML
    void onClickEmpleado(MouseEvent event) {

    }

    @FXML
    void onClickInventario(MouseEvent event) {

    }

    @FXML
    void onClickProveedor(MouseEvent event) {
        App.newStage("Proveedores","Tabla de proveedores");
    }

}
