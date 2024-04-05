package com.davity.ipa.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.davity.ipa.App;
import com.davity.ipa.Models.Administrador;
import com.davity.ipa.Models.Empleado;
import com.davity.ipa.Models.Persona;
import com.davity.ipa.Models.Usuario;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class InicioSesion {

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
    void OnclickEquit(MouseEvent event) {
        Platform.exit();
    }

    //EMPLEADO
    Empleado emple = new Empleado("david","1234","","","","");
    String idEmpleado = emple.getId();
    String passwordEmpleado = emple.getPassword();

    //ADMINISTRADOR
    Administrador admin = new Administrador("francisco","333");
    String idAdmin = admin.getId();
    String passwordAdmin = admin.getPassword();

    @FXML
    void OnclickIngresar(MouseEvent event) {
        if (TextFieldId.getText().equals(idEmpleado) && PasswordFieldPassword.getText().equals(passwordEmpleado)) {
            System.out.println("INGRESADO");
            Textincorrectos.setText("");
            TextFieldId.clear();
            PasswordFieldPassword.clear();
            App.newStage("HomeEmpleado", "Bienvenido Empleado");

        } else if (TextFieldId.getText().equals(idAdmin) && PasswordFieldPassword.getText().equals(passwordAdmin)) {
            System.out.println("INGRESADO");
            Textincorrectos.setText("");
            TextFieldId.clear();
            PasswordFieldPassword.clear();
            App.newStage("HomeAdministrador", "Bienvenido Administrador");

        } else {
            System.out.println("incorrecto");
            Textincorrectos.setText("Datos Incorrectos");

        }

    }

/*
    String password = TextFieldpassword.getText();

    String newPassword = TextFieldpasswordNew.getText();
    password = newPassword;
 */

    @FXML
    void OnclickOlvido(MouseEvent event) {
        App.newStage("RecuperarPassword","Recuperar contraseña");
    }


}


//welcomeText.setText("Welcome to JavaFX Application!");
