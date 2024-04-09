package com.davity.ipa.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public interface HomeAdministradorInterface extends Initializable {


    public void onClickBeneficiario(MouseEvent event);
    public void onClickCerrarSesion(MouseEvent event);
    public void onClickEliminar(MouseEvent event);
    public void onClickEmpleado(MouseEvent event);
    public void onClickInventario(MouseEvent event);
    public void onClickProveedor(MouseEvent event);
    public void onClickbuscar(MouseEvent event);
    public void initialize(URL url, ResourceBundle resourceBundle);

}
