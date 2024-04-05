package com.davity.ipa.Controllers;

import com.davity.ipa.App;
import com.davity.ipa.Models.Proveedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Proveedores implements Initializable {

    @FXML
    private ImageView empleado;

    @FXML
    private ImageView inicio;

    @FXML
    private ImageView inventario;

    @FXML
    private ImageView beneficiario;

    @FXML
    private ImageView proveedor;

    @FXML
    private ImageView btnAnadirProveedor;

    @FXML
    private ImageView btnEliminarProveedor;

    @FXML
    private ImageView btnModificar;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNumero;

    @FXML
    private TableColumn<Proveedor, String> nombre;

    @FXML
    private TableColumn<Proveedor, String> telefono;

    @FXML
    private TableColumn<Proveedor, String> correo;

    @FXML
    private TableColumn<Proveedor, String> domicilio;

    @FXML
    private TableView<Proveedor> tablaProveedores;

    private ObservableList<Proveedor> provedores;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        provedores = FXCollections.observableArrayList();
        tablaProveedores.setItems(provedores);

        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        telefono.setCellValueFactory(new PropertyValueFactory<>("numeroTelefono"));
        domicilio.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        correo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        tablaProveedores.getColumns().addAll(nombre,telefono,domicilio,correo);

        txtNumero.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue.matches("\\d*")|| "0".equals(newValue)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Solo puedes ingresar números");
                alert.showAndWait();

                txtNumero.setText(oldValue);
            }
        });
    }

    @FXML
    void OnclickAnadirProveedor(MouseEvent event) {
        String name = this.txtNombre.getText();
        String number = this.txtNumero.getText();
        String direction = this.txtDireccion.getText();
        String email = this.txtCorreo.getText();

        Proveedor p = new Proveedor(name,number,direction,email);
        boolean vacio = true;

        if(name.isEmpty() || number.isEmpty() || direction.isEmpty() || email.isEmpty()){
            vacio = false;
        }

        Boolean existe = false;
        for(Proveedor prover : provedores){
        if(prover.getNombre().equals(p.getNombre()) || prover.getCorreo().equals(p.getCorreo())){
                existe = true;
                break;
            }
        }
        if (existe) {
            // Mostrar una alerta indicando que la persona ya existe
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("El proveedor ya existe");
            alert.showAndWait();
        } else {

            if(!vacio){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("CORREO INVALIDO");
                alert.setHeaderText(null);
                alert.setContentText("No puedes dejar campos vacios");
                alert.showAndWait();
            }else {

                if (!txtCorreo.getText().contains("@") || !txtCorreo.getText().contains(".")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("CORREO INVALIDO");
                    alert.setHeaderText(null);
                    alert.setContentText("El correo es invalido");
                    alert.showAndWait();
                } else {
                    provedores.add(p);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Agregado");
                    alert.setHeaderText(null);
                    alert.setContentText("Proveedor agregado exitosamente ✔");
                    alert.showAndWait();

                    txtNombre.clear();
                    txtCorreo.clear();
                    txtDireccion.clear();
                    txtNumero.clear();
                }
            }
        }
    }

    @FXML
    void seleccionar(MouseEvent event) {
        Proveedor p = this.tablaProveedores.getSelectionModel().getSelectedItem();
        if(p !=null){
            this.txtNombre.setText(p.getNombre());
            this.txtNumero.setText(p.getNumeroTelefono());
            this.txtCorreo.setText(p.getCorreo());
            this.txtDireccion.setText(p.getDireccion());
        }
    }

    @FXML
    void OnclickModificarDatos(MouseEvent event) {
        Proveedor p = this.tablaProveedores.getSelectionModel().getSelectedItem();

        if(p == null){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor seleccione a un proveedor");
            alert.showAndWait();

        }else {
            try {
                String name = this.txtNombre.getText();
                String number = this.txtNumero.getText();
                String direction = this.txtDireccion.getText();
                String email = this.txtCorreo.getText();

                Proveedor pro = new Proveedor(name,number,direction,email);

                if(!this.provedores.contains(pro)){

                    p.setNombre(pro.getNombre());
                    p.setNumeroTelefono(pro.getNumeroTelefono());
                    p.setDireccion(pro.getDireccion());
                    p.setCorreo(pro.getCorreo());

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Modificado");
                    alert.setHeaderText(null);
                    alert.setContentText("Proveedor modificado");
                    alert.showAndWait();

                    this.tablaProveedores.refresh();

                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("El Proveedor existe");
                    alert.showAndWait();
                }


            }catch (NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Formato incorrecto");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void OnclickEliminar(MouseEvent event) {
        Proveedor p = this.tablaProveedores.getSelectionModel().getSelectedItem();

        if(p == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Selecciona a un proveedor en la tabla");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Proveedor eliminado");
            alert.showAndWait();

            this.provedores.remove(p);
            this.tablaProveedores.refresh();
        }

    }

    @FXML
    void onClickBeneficiario(MouseEvent event) {
        App.newStage("Beneficiario","Tabla de beneficiarios");
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

    }

}

