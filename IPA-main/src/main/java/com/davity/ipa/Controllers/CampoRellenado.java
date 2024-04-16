package com.davity.ipa.Controllers;

import com.davity.ipa.App;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CampoRellenado {

    @FXML
    private ImageView cancelar1;

    @FXML
    private TextField cantidad;

    @FXML
    private TextField clasificacion;

    @FXML
    private TextField nombre;

    @FXML
    private ImageView ok;

    @FXML
    void onClickCancelar(MouseEvent event) {

    }

    @FXML
    void onClickOk(MouseEvent event) {
        App.newStage("ProductosEmpleado","Agregar productos");
    }

}
