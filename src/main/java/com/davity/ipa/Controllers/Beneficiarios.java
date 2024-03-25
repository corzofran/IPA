package com.davity.ipa.Controllers;

import com.davity.ipa.Models.Beneficiario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Beneficiarios {
    @FXML
    private TextField NumeroTelefono;

    @FXML
    private ImageView anadir;

    @FXML
    private ImageView beneficiario;

    @FXML
    private ImageView crear;

    @FXML
    private TableColumn<Beneficiario, String> curp;

    @FXML
    private TableColumn<Beneficiario, String> domicilio;

    @FXML
    private ImageView eliminar;

    @FXML
    private ImageView empleado;

    @FXML
    private TextField ingresarCurp;

    @FXML
    private ImageView inicio;

    @FXML
    private ImageView inventario;

    @FXML
    private TextField lugarDomicilio;

    @FXML
    private ImageView modificar;

    @FXML
    private TableColumn<Beneficiario, String> nombre;

    @FXML
    private TextField nombreCompleto;

    @FXML
    private ImageView proveedor;

    @FXML
    private TableView<Beneficiario> tablaBeneficiarios;

    @FXML
    private TableColumn<Beneficiario, String> telefono;

    @FXML
    void onClickAnadirBeneficiario(MouseEvent event) {

}

    @FXML
    void onClickBeneficiario(MouseEvent event) {

    }

    @FXML
    void onClickCrearBeneficiario(MouseEvent event) {

    }

    @FXML
    void onClickEliminar(MouseEvent event) {

    }

    @FXML
    void onClickEliminarBeneficiario(MouseEvent event) {

    }

    @FXML
    void onClickEmpleado(MouseEvent event) {

    }

    @FXML
    void onClickInventario(MouseEvent event) {

    }

    @FXML
    void onClickModificarDatos(MouseEvent event) {

    }

    @FXML
    void onClickProveedor(MouseEvent event) {


    }

    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;
}


