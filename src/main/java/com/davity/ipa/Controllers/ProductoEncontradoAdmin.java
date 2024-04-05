package com.davity.ipa.Controllers;

import com.davity.ipa.Models.Objetos;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ProductoEncontradoAdmin {

    @FXML
    private ImageView btnBeneficiario;

    @FXML
    private ImageView btnEmpleado;

    @FXML
    private ImageView btnProveedor;

    @FXML
    private ImageView btninicio;

    @FXML
    private Label cantidad;

    @FXML
    private ImageView cerrarSesion;

    @FXML
    private Label clasificacion;

    @FXML
    private ImageView inventario;

    @FXML
    private Label producto;

    public static int arrayPosicion;

    public static int getArrayPosicion() {
        return arrayPosicion;
    }

    public static void setArrayPosicion(int arrayPosicion) {
        ProductoEncontradoAdmin.arrayPosicion = arrayPosicion;
    }

    @FXML
    void onClickBeneficiario(MouseEvent event) {

    }

    @FXML
    void onClickCerrarSesion(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickEmpleado(MouseEvent event) {

    }

    @FXML
    void onClickInicio(MouseEvent event) {

    }

    @FXML
    void onClickProveedor(MouseEvent event) {

    }

    @FXML
    void initialize() {
        ArrayList<String> namesproducts = Objetos.getProductnames();
        ArrayList<Integer> quantityproduct = Objetos.getProductquantitys();
        ArrayList<String> clasification = Objetos.getProductclasifications();

        Objetos product = new Objetos();


        System.out.println(getArrayPosicion());

        producto.setText(namesproducts.get(arrayPosicion));
        cantidad.setText(String.valueOf(quantityproduct.get(arrayPosicion)));
        clasificacion.setText(clasification.get(arrayPosicion));
    }

}

