package com.davity.ipa.Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.davity.ipa.App;
import com.davity.ipa.Models.Objetos;
import com.davity.ipa.Models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeAdministrador implements HomeAdministradorInterface{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private Text txtNotification;

    ArrayList<String> nameproduct = Objetos.getProductnames();
    Usuario u = new Usuario();
    int notificacion = Usuario.getNotificacion();
    @FXML
   public void onClickBeneficiario(MouseEvent event) {
        App.newStage("Beneficiario", "agregar beneficiarios");
    }

    @FXML
    public void onClickCerrarSesion(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onClickEliminar(MouseEvent event) {

    }

    @FXML
    public void onClickEmpleado(MouseEvent event) {
        App.newStage("Empleados", "Tabla de empleados");
    }

    @FXML
    public void onClickInventario(MouseEvent event) {
        App.newStage("ProductosAdministrador", "Inventario");
    }

    @FXML
   public void onClickProveedor(MouseEvent event) {
        App.newStage("Proveedores", "Proveedores");
    }

    @FXML
    public void onClickbuscar(MouseEvent event) {
        String textfield = buscador.getText();

        boolean encontrado = false;
        for (int i = 0; i < nameproduct.size(); i++) {
            String producto = nameproduct.get(i);
            if (textfield.equals(producto)) {
                encontrado = true;
                ProductoEncontradoAdmin.setArrayPosicion(i);
                System.out.println(i);
                buscador.clear();
                App.newStage("ProductoEncontradoAdmin", "Producto encontrado");
                break;
            }
        }

        if (!encontrado) {
            buscador.clear();
            App.newStage("ProductoNoEncontradoAdmin", "No existe este producto");
        }
    }

    @FXML
    void OnclickNotification(MouseEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtNotification.setText(String.valueOf(notificacion));
        buscador.clear();

        beneficiario.setOnMouseEntered(event -> {
            beneficiario.setEffect(new DropShadow());
        });

        beneficiario.setOnMouseExited(event -> {
            beneficiario.setEffect(null);
        });


        inventario.setOnMouseEntered(event -> {
            inventario.setEffect(new DropShadow());
        });

        inventario.setOnMouseExited(event -> {
            inventario.setEffect(null);
        });

        empleado.setOnMouseEntered(event -> {
            empleado.setEffect(new DropShadow());
        });

        empleado.setOnMouseExited(event -> {
            empleado.setEffect(null);
        });

        proveedor.setOnMouseEntered(event ->{
            proveedor.setEffect(new DropShadow());
        });

        proveedor.setOnMouseExited(event ->{
            proveedor.setEffect(null);
        });

        buscar.setOnMouseEntered(event ->{
            buscar.setEffect(new InnerShadow());
        });

        buscar.setOnMouseExited(event ->{
            buscar.setEffect(null);
        });

        cerrarSesion.setOnMouseEntered(event -> {
            cerrarSesion.setEffect(new DropShadow());
        });

        cerrarSesion.setOnMouseExited(event -> {
            cerrarSesion.setEffect(null);
        });
    }
}


