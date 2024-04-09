package com.davity.ipa.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public interface InicioSesionInterface extends Initializable {

    void OnclickEquit(MouseEvent event);
    void OnclickIngresar(MouseEvent event1);
    void OnclickOlvido(MouseEvent event);

    public void initialize(URL url, ResourceBundle resourceBundle);
}
