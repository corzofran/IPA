package com.davity.ipa.Controllers;

import com.davity.ipa.Models.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

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
    private TableView<Empleado> tablaBeneficiarios;

    private ObservableList<Empleado> empleados;

    Empleado e = new Empleado("","","","","","");
    String sexo = e.getSexo();
    String password = e.getPassword();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        empleados = FXCollections.observableArrayList();
        tablaBeneficiarios.setItems(empleados);

        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        correo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        numero.setCellValueFactory(new PropertyValueFactory<>("numeroTelefonico"));
        genero.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        contrasenia.setCellValueFactory(new PropertyValueFactory<>("password"));
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



        Boolean existe = false;
        for(Empleado e : empleados){
            if(e.getNombre().equals(empleoyee.getNombre()) || e.getNumeroTelefonico().equals(empleoyee.getNumeroTelefonico())
            || e.getId().equals(empleoyee.getId())){
                existe = true;
                break;
            }
        }

        if (existe) {
            // Mostrar una alerta indicando que la persona ya existe
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Este empleado ya existe");
            alert.showAndWait();
        }else{
            empleados.add(empleoyee);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText(null);
            alert.setContentText("Empleado agregado");
            alert.showAndWait();

            DropShadow dropShadow = new DropShadow();
            dropShadow.setColor(Color.GRAY);
            dropShadow.setRadius(0);
            dropShadow.setSpread(0); // Extensión del borde iluminado
            btnHombre.setEffect(dropShadow);

            txtNombre.clear();
            txtCorreo.clear();
            txtNumero.clear();
            txtid.clear();
            labelContrasenia.setText("");

        }

    }
    @FXML
    void OnclickContrasenia(MouseEvent event) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        password = "";
        Random random = new Random();

        for(int i=0; i<8 ; i++){
            int j = random.nextInt(characters.length());
            password = password + characters.charAt(j);
        }
        labelContrasenia.setText(password);
    }

    @FXML
    void seleccionar(MouseEvent event) {

    }

    @FXML
    void OnclickModificarDatos(MouseEvent event) {

    }

    @FXML
    void OnclickEliminarEmpleado(MouseEvent event) {

    }

    @FXML
    void OnclickUsuario(MouseEvent event) {

    }

    @FXML
    void onClickBeneficiario(MouseEvent event) {

    }

    @FXML
    void onClickEmpleado(MouseEvent event) {

    }

    @FXML
    void onClickInventario(MouseEvent event) {

    }

    @FXML
    void onClickProveedor(MouseEvent event) {

    }

}
