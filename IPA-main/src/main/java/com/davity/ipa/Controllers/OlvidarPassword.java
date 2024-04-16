package com.davity.ipa.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.davity.ipa.App;
import com.davity.ipa.Models.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OlvidarPassword implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enviar;

    @FXML
    private TextField nombre;

    @FXML
    private Button volver;

    @FXML
    private Text repetido;

    private Empleados empleado;
    public void Usuario(Empleados empleados) {
        this.empleado=empleados;
    }

    //francisco

    Usuario usuary = new Usuario("david","1234");
    String id = usuary.getId();
    ArrayList<String> arrayNames = usuary.getRecuperarNames();
    String usuarioSelect;
    int notificar;
    int notification;
    @FXML
    void onClickEnviar(MouseEvent event) {

        /*
        if(nombre.getText().equals(id)){
            App.newStage("PasswordEnviada","Contraseña enviada");
        } else {
            repetido.setText("No existe este nombre");
        }

         */

        boolean datosCorrectos = false;

        for (int i = 0; i < arrayNames.size(); i++) {
            if (nombre.getText().equals(arrayNames.get(i))) {
                datosCorrectos = true;
                usuarioSelect=arrayNames.get(i);
                break;
            }
        }
        if (datosCorrectos) {
            System.out.println("DATOS CORRECTO EMPLEADO");
            App.newStage("PasswordEnviada","Contraseña enviada");
            notification = Usuario.setNotificacion(notificar+1);

            System.out.println(arrayNames);
            System.out.println(usuarioSelect);
            System.out.println(notification);

        } else {
            System.out.println("DATOS INCORRECTO EMPLEADO");
            repetido.setText("No existe este nombre");
        }
    }

    @FXML
    void onClickVolver(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

