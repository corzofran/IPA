package com.davity.ipa.Controllers;

import com.davity.ipa.App;
import com.davity.ipa.Models.Beneficiario;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.net.URL;
import java.util.ResourceBundle;

public class Beneficiarios implements Initializable {

    @FXML
    private ImageView beneficiario;

    @FXML
    private ImageView btnAnadirBeneficiario;

    @FXML
    private ImageView btnEliminarBeneficiario;

    @FXML
    private ImageView btnModificarDatos;

    @FXML
    private ImageView empleado;

    @FXML
    private ImageView inicio;

    @FXML
    private ImageView inventario;

    @FXML
    private ImageView proveedor;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtCurp;

    @FXML
    private TableView<Beneficiario> tablaBeneficiarios;

    @FXML
    private TableColumn<Beneficiario, String> nombre;

    @FXML
    private TableColumn<Beneficiario, String> telefono;

    @FXML
    private TableColumn<Beneficiario, String> domicilio;

    @FXML
    private TableColumn<Beneficiario, String> curp;

    private ObservableList<Beneficiario> beneficiarios;

    private ValidationSupport validacion;

    //francisco
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        beneficiarios = FXCollections.observableArrayList();
        tablaBeneficiarios.setItems(beneficiarios);


        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        telefono.setCellValueFactory(new PropertyValueFactory<>("numeroTelefono"));
        domicilio.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        curp.setCellValueFactory(new PropertyValueFactory<>("curp"));
        tablaBeneficiarios.getColumns().addAll(nombre,telefono,domicilio,curp);

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
    void OnclickAnadirBeneficiario(MouseEvent event) {

            String name = this.txtNombre.getText();
            String number = this.txtNumero.getText();
            String direccion = this.txtDireccion.getText();
            String clavaUnica = this.txtCurp.getText();
            String correo = null;
            boolean vacio =false;

            Beneficiario beneficiary = new Beneficiario(name, number, direccion, clavaUnica, correo);




                boolean existe = false;
                for (Beneficiario p : beneficiarios) {
                    if (p.getCurp().equals(beneficiary.getCurp()) || p.getNombre().equals(beneficiary.getNombre())) {
                        existe = true;
                        break;
                    }
                }

        if(name.isEmpty() || number.isEmpty() || direccion.isEmpty() || clavaUnica.isEmpty()){
            vacio = true;
        }

        if (vacio) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("No puedes dejar campos vacíos");
            alert.showAndWait();
        } else if (existe) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Este beneficiario ya existe");
            alert.showAndWait();
        } else {
            beneficiarios.add(beneficiary);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setHeaderText(null);
            alert.setContentText("Beneficiario agregado");
            alert.showAndWait();

            txtCurp.clear();
            txtDireccion.clear();
            txtNombre.clear();
            txtNumero.clear();
        }

    }

    @FXML
    void seleccionar(MouseEvent event) {
        Beneficiario b =this.tablaBeneficiarios.getSelectionModel().getSelectedItem();

        if(b !=null){
        this.txtNombre.setText(b.getNombre());
        this.txtNumero.setText(b.getNumeroTelefono());
        this.txtDireccion.setText(b.getDireccion());
        this.txtCurp.setText(b.getCurp());
        }
    }

    @FXML
    void onClickModificarDatos(MouseEvent event) {

        Beneficiario b =this.tablaBeneficiarios.getSelectionModel().getSelectedItem();

        if(b ==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor seleccione a un beneficiario");
            alert.showAndWait();
        }else{

            try {

                String name = this.txtNombre.getText();
                String number = this.txtNumero.getText();
                String direccion = this.txtDireccion.getText();
                String clavaUnica = this.txtCurp.getText();
                String correo = null;

                Beneficiario beneficiary = new Beneficiario(name, number, direccion, clavaUnica, correo);

                if (!this.beneficiarios.contains(beneficiary)) {

                    b.setNombre(beneficiary.getNombre());
                    b.setNumeroTelefono(beneficiary.getNumeroTelefono());
                    b.setDireccion(beneficiary.getDireccion());
                    b.setCurp(beneficiary.getCurp());

                    this.tablaBeneficiarios.refresh();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Modificado");
                    alert.setHeaderText(null);
                    alert.setContentText("Beneficiario modificado");
                    alert.showAndWait();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("El beneficiario existe");
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
    void onClickEliminarBeneficiario(MouseEvent event) {
        Beneficiario b =this.tablaBeneficiarios.getSelectionModel().getSelectedItem();

        if(b == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Selecciona a un beneficiario en la tabla");
            alert.showAndWait();
        }else {
            this.beneficiarios.remove(b);
            this.tablaBeneficiarios.refresh();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Beneficiario Eliminado");
            alert.showAndWait();
        }
    }

    @FXML
    void onKeyCurp(KeyEvent event) {
        if(txtCurp.getText().length() >= 18){
            event.consume();
        }
    }

    @FXML
    void onClickEliminar(MouseEvent event) {

    }


    @FXML
    void onClickBeneficiario(MouseEvent event) {
        App.newStage("Beneficiario","Tabla de beneficiarios");
    }


    @FXML
    void onClickEmpleado(MouseEvent event) {
        App.newStage("Empleados","Tabla de empleados");
    }

    @FXML
    void onClickInventario(MouseEvent event) {
        App.newStage("ProductosAdministrador","Tabla de productos");
    }

    @FXML
    void onClickProveedor(MouseEvent event) {
        App.newStage("Proveedores","Tabla de proveedores");
    }

}
