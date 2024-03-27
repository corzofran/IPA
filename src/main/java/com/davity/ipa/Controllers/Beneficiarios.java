package com.davity.ipa.Controllers;

import com.davity.ipa.App;
import com.davity.ipa.Models.Beneficiario;
import com.davity.ipa.Models.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Beneficiarios implements Initializable {

    @FXML
    private ImageView beneficiario;

    @FXML
    private ImageView empleado;

    @FXML
    private ImageView inicio;

    @FXML
    private ImageView inventario;

    @FXML
    private ImageView proveedor;

    @FXML
    private ImageView btnAnadirBeneficiario;

    @FXML
    private ImageView btnEliminarBeneficiario;

    @FXML
    private ImageView btnModificarDatos;

    @FXML
    private TableView<Beneficiario> tablaBeneficiarios;

    @FXML
    private TableColumn telefono;

    @FXML
    private TableColumn nombre;

    @FXML
    private TableColumn curp;

    @FXML
    private TableColumn domicilio;

    private ObservableList<Beneficiario> Beneficiarios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Beneficiarios = FXCollections.observableArrayList();
        this.tablaBeneficiarios.setItems(Beneficiarios);

        this.nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.telefono.setCellValueFactory(new PropertyValueFactory("numeroTelefono"));
        this.domicilio.setCellValueFactory(new PropertyValueFactory("direccion"));
        this.curp.setCellValueFactory(new PropertyValueFactory("curp"));
    }


    @FXML
    void onClickBeneficiario(MouseEvent event) {
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

    public void OnclickAnadirBeneficiario(MouseEvent mouseEvent) {
        App.newStage("AgregarBeneficiario","Agrega los datos");
    }
}



