package com.davity.ipa.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.davity.ipa.App;
import com.davity.ipa.Models.Objetos;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeAdministrador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView agregar;

    @FXML
    private ImageView beneficiario;

    @FXML
    private TextField buscador;

    @FXML
    private ImageView buscar;

    @FXML
    private ImageView cerrarSesion;

    @FXML
    private ImageView eliminar;

    @FXML
    private ImageView empleado;

    @FXML
    private ImageView inicio;

    @FXML
    private ImageView inventario;

    @FXML
    private ImageView proveedor;

    @FXML
    private Text usuario;

    @FXML
    void onClickAgregar(MouseEvent event) {

    }

    @FXML
    void onClickBeneficiario(MouseEvent event) {
       App.newStage("Beneficiario","agregar beneficiarios");
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
    void onClickEmpleado(MouseEvent event) {
        App.newStage("Empleados","Tabla de empleados");
    }

    @FXML
    void onClickInventario(MouseEvent event) {
        App.newStage("ProductosAdministrador","Inventario");
    }

    @FXML
    void onClickProveedor(MouseEvent event) {
        App.newStage("Proveedores","Proveedores");
    }

    @FXML
    void onClickbuscar(MouseEvent event) {
        String textfield = buscador.getText();
        ArrayList<String> nameproduct = Objetos.getProductnames();

        boolean encontrado = false;
        for (int i = 0; i < nameproduct.size(); i++) {
            String producto = nameproduct.get(i);
            if (textfield.equals(producto)) {
                encontrado = true;
                ProductoEncontradoAdmin.setArrayPosicion(i);
                System.out.println(i);
                buscador.clear();
              App.newStage("ProductoEncontradoAdmin","Producto encontrado");
                break;
            }
        }

        if (!encontrado) {
            buscador.clear();
           App.newStage("ProductoNoEncontradoAdmin","No existe este producto");
        }
    }

    @FXML
    void initialize() {
        buscador.clear();
    }

}


