package com.davity.ipa.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ProductoNoEncontradoAdmin {

    @FXML
    private ImageView btnBeneficiario;

    @FXML
    private ImageView btnEmpleado;

    @FXML
    private ImageView btnInicio;

    @FXML
    private ImageView btnProveedor;

    @FXML
    private ImageView btninventario;

    @FXML
    private ImageView inventario;

    @FXML
    private ImageView volver;

    @FXML
    void onClickBeneficiario(MouseEvent event) {

    }

    @FXML
    void onClickEmpleado(MouseEvent event) {

    }

    @FXML
    void onClickInicio(MouseEvent event) {

    }

    @FXML
    void onClickInventario(MouseEvent event) {

    }

    @FXML
    void onClickProveedor(MouseEvent event) {

    }

    @FXML
    void onClickVolver(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}

