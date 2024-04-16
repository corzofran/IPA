package com.davity.ipa.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.davity.ipa.Models.Producto;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProductoEncontrado {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView agregar;

    @FXML
    private ImageView cerrarSesion;

    @FXML
    private Label producto;

    @FXML
    private Label cantidad;

    @FXML
    private Label clasificacion;

    @FXML
    private Label mark;

    @FXML
    private ImageView eliminar;

    @FXML
    private ImageView inicio;

    @FXML
    private ImageView inventario;

    @FXML
    private Text usuario;

    public static int arrayPosicion;

    public static int getArrayPosicion() {
        return arrayPosicion;
    }

    public static void setArrayPosicion(int arrayPosicion) {
        ProductoEncontrado.arrayPosicion = arrayPosicion;
    }

    @FXML
    void onClickAgregar(MouseEvent event) {

    }

    @FXML
    void onClickCerrarSesion(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickInventario(MouseEvent event) {

    }

    @FXML
    void initialize() {
        ArrayList<String> namesproducts = Producto.getProductname();
        ArrayList<Integer> quantityproduct = Producto.getProductquantity();
        ArrayList<String> clasification = Producto.getProductclasification();
        ArrayList<String> marca = Producto.getProductmark();

       Producto product = new Producto();


        System.out.println(getArrayPosicion());

        producto.setText(namesproducts.get(arrayPosicion));
        cantidad.setText(String.valueOf(quantityproduct.get(arrayPosicion)));
        clasificacion.setText(clasification.get(arrayPosicion));
        mark.setText(marca.get(arrayPosicion));
    }
    @FXML
    void onClickEliminar(MouseEvent event) {

    }

    @FXML
    void onClickInicio(MouseEvent event) {

    }
}

