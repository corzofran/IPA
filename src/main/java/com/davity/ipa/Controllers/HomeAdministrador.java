package com.davity.ipa.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.davity.ipa.App;
import com.davity.ipa.Models.Empleado;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

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

    }

    @FXML
    void onClickProveedor(MouseEvent event) {
        App.newStage("Proveedores","Proveedores");
    }

    @FXML
    void onClickbuscar(MouseEvent event) {

    }

    @FXML
    void initialize() {
        Empleado emple = new Empleado("david","1234","","","","");
        usuario.setText(emple.getId());
    }

}


