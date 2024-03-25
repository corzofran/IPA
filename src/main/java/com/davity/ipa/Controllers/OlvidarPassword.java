package com.davity.ipa.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.davity.ipa.App;
import com.davity.ipa.Models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OlvidarPassword {

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

    Usuario usuary = new Usuario("david","1234");
    String id = usuary.getId();

    @FXML
    void onClickEnviar(MouseEvent event) {
        if(nombre.getText().equals(id)){
            App.newStage("PasswordEnviada","Contraseña enviada");
        } else {
            repetido.setText("No existe este nombre");
        }
    }

    @FXML
    void onClickVolver(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {

    }

}

