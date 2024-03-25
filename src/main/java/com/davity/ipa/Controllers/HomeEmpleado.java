package com.davity.ipa.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import com.davity.ipa.App;
import com.davity.ipa.Models.Empleado;
import com.davity.ipa.Models.Producto;
import com.davity.ipa.Models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeEmpleado {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView agregar;

    @FXML
    private TextField buscador;

    @FXML
    private ImageView buscar;

    @FXML
    private ImageView cerrarSesion;

    @FXML
    private ImageView eliminar;

    @FXML
    private ImageView inicio;

    @FXML
    private ImageView inventario;

    @FXML
    private Text usuario;

    @FXML
    void onClickAgregar(MouseEvent event) {
        App.newStage("ProductosEmpleado","Agregar Productos");
    }

    @FXML
    void onClickCerrarSesion(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
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
        public static String producto;

    @FXML
    void onClickbuscar(MouseEvent event) {
        String textfield = buscador.getText();
        ArrayList<String> nameproduct = Producto.getProductname();

        boolean encontrado = false;
        for (int i = 0; i < nameproduct.size(); i++) {
            String producto = nameproduct.get(i);
            if (textfield.equals(producto)) {
                encontrado = true;
                ProductoEncontrado.setArrayPosicion(i);
                System.out.println(i);
                App.newStage("ProductoEncontrado","Producto encontrado");
                break;
            }
        }

        if (!encontrado) {
            App.newStage("ProductoNoEncontrado","No existe este producto");
        }

    }

    Empleado emple = new Empleado("david","1234");
    @FXML
    void initialize() {
        usuario.setText(emple.getId());
    }

}


