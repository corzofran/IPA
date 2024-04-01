package com.davity.ipa.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.davity.ipa.Models.Empleado;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProductoNoEncontrado {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView agregar;

    @FXML
    private ImageView eliminar;

    @FXML
    private ImageView inicio;

    @FXML
    private ImageView inventario;

    @FXML
    private Text usuario;

    @FXML
    private ImageView volver;

    @FXML
    void onClickAgregar(MouseEvent event) {

    }

    @FXML
    void onClickEliminar(MouseEvent event) {

    }

    @FXML
    void onClickInicio(MouseEvent event) {

    }

    @FXML
    void onClickInventario(MouseEvent event) {

    }

    @FXML
    void onClickVolver(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
         Empleado emple = new Empleado("david","1234","","","","");
        usuario.setText(emple.getId());
    }

}
