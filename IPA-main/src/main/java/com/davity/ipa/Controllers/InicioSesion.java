package com.davity.ipa.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.davity.ipa.App;
import com.davity.ipa.Models.Administrador;
import com.davity.ipa.Models.Empleado;
import com.davity.ipa.Models.Persona;
import com.davity.ipa.Models.Usuario;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class InicioSesion implements InicioSesionInterface {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonIngresar;

    @FXML
    private Button ButtonOlvido;

    @FXML
    private ImageView ButtonQuit;

    @FXML
    private PasswordField PasswordFieldPassword;

    @FXML
    private TextField TextFieldId;
    @FXML
    private Text Textincorrectos;

    @FXML
    public void OnclickEquit(MouseEvent event) {
        Platform.exit();
    }

    //ADMINISTRADOR
    String usarioAdmin = "david";
    String passwordAdmin = "333";
    Administrador admin = new Administrador(usarioAdmin, passwordAdmin);
    //EMPLEADO
    Usuario u = new Usuario();
    ArrayList<String> arrayId = Usuario.getUsuario();
    ArrayList<String> arrayPassword = Usuario.getContrasena();

    String usuarioSelect = Empleado.getUsuarioSelect();

    @FXML
    public void OnclickIngresar(MouseEvent event1) {

        TextFieldId.setOnMouseClicked(event ->{
            Textincorrectos.setText("");
                });

        if (TextFieldId.getText().equals(usarioAdmin) && PasswordFieldPassword.getText().equals(passwordAdmin)) {
            System.out.println("INGRESADO ADMIN");
            Textincorrectos.setText("");
            TextFieldId.clear();
            PasswordFieldPassword.clear();

            System.out.println(arrayId);
            System.out.println(arrayPassword);
            App.newStage("HomeAdministrador", "Bienvenido Administrador");
            return;
        } else {
            System.out.println("incorrecto admin");
            Textincorrectos.setText("Datos Incorrectos");
        }

        //EMPLEADO
        boolean datosCorrectos = false;

        for (int i = 0; i < arrayId.size(); i++) {
            if (TextFieldId.getText().equals(arrayId.get(i)) && PasswordFieldPassword.getText().equals(arrayPassword.get(i))) {
                datosCorrectos = true;
                usuarioSelect=arrayId.get(i);
                break;
            }
        }
        if (datosCorrectos) {
            System.out.println(arrayId);
            System.out.println(arrayPassword);
            System.out.println(usuarioSelect);

            App.newStage("HomeEmpleado", "Bienvenido Empleado");
            System.out.println("DATOS CORRECTO EMPLEADO");
            Textincorrectos.setText("");
            TextFieldId.clear();
            PasswordFieldPassword.clear();
        } else {
            System.out.println("DATOS INCORRECTO EMPLEADO");
            Textincorrectos.setText("Datos Incorrectos");
        }
    }

    @FXML
    public void OnclickOlvido(MouseEvent event) {
        App.newStage("RecuperarPassword","Recuperar contraseña");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //BUTON INGRESAR
        ButtonIngresar.setOnMouseEntered(event -> {
            ButtonIngresar.setStyle("-fx-background-color: #697d94;");
        });

        ButtonIngresar.setOnMouseExited(event -> {
            ButtonIngresar.setStyle("-fx-background-color: #8497b0;");
        });

        //BUTON OLVIDAR
        ButtonOlvido.setOnMouseEntered(event -> {
            ButtonOlvido.setStyle("-fx-background-color:#697d94; ");
        });

        ButtonOlvido.setOnMouseExited(event ->{
            ButtonOlvido.setStyle("-fx-background-color:#8497b0;  ");
        });

        //BOTON SALIR
        ButtonQuit.setOnMouseEntered(event -> {
            ButtonQuit.setEffect(new DropShadow());
        });

        ButtonQuit.setOnMouseExited(event ->{
            ButtonQuit.setEffect(null);
        });
    }
}
