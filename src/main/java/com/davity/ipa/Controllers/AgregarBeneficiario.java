package com.davity.ipa.Controllers;

import com.davity.ipa.Models.Beneficiario;
import com.davity.ipa.Models.Persona;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AgregarBeneficiario implements Initializable {

    @FXML
    private ImageView btnGuardar;

    @FXML
    private ImageView btnSalir;

    @FXML
    private TextField txtCurp;

    @FXML
    private TextField txtDomicilio;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNumero;


    private ObservableList<Persona> Beneficiarios;



    @FXML
    private void guardar(MouseEvent event) {


    }

    @FXML
    void salir(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
