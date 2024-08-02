package com.davity.ipa.Controllers;

import com.davity.ipa.Models.Beneficiario;
import com.davity.ipa.Utils.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    @FXML
    private TextField txtCorreo;

    private DatabaseConnection dbConnection;

    @FXML
    private void guardar(MouseEvent event) {
        String nombre = txtNombre.getText();
        String domicilio = txtDomicilio.getText();
        String numero = txtNumero.getText();
        String curp = txtCurp.getText();
        String correo = txtCorreo.getText();

        // Imprimir los datos ingresados
        System.out.println("Nombre: " + nombre);
        System.out.println("Domicilio: " + domicilio);
        System.out.println("Número Telefónico: " + numero);
        System.out.println("CURP: " + curp);
        System.out.println("Correo: " + correo);

        if (nombre.isEmpty() || domicilio.isEmpty() || numero.isEmpty() || curp.isEmpty() || correo.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos Vacíos");
            alert.setContentText("Todos los campos deben ser llenados");
            alert.showAndWait();
            return;
        }

        Beneficiario beneficiario = new Beneficiario(nombre, numero, domicilio, curp, correo);

        String sql = "INSERT INTO beneficiarios (nombre, domicilio, numero_telefonico, curp, correo) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, beneficiario.getNombre());
            pstmt.setString(2, beneficiario.getDireccion());
            pstmt.setString(3, beneficiario.getNumeroTelefono());
            pstmt.setString(4, beneficiario.getCurp());
            pstmt.setString(5, beneficiario.getCorreo());

            pstmt.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText("Beneficiario Guardado perfectamente");
            alert.setContentText("El beneficiario ha sido guardado exitosamente.");
            alert.showAndWait();

            limpiarCampos();

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al Guardar");
            alert.setContentText("Ocurrió un error al guardar el beneficiario.");
            alert.showAndWait();
        }
    }

    @FXML
    void salir(MouseEvent event) {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtDomicilio.clear();
        txtNumero.clear();
        txtCurp.clear();
        txtCorreo.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbConnection = new DatabaseConnection();
    }

    // Asegúrate de cerrar la conexión cuando la ventana se cierre
    public void closeConnection() {
        if (dbConnection != null) {
            dbConnection.closeConnection();
        }
    }
}
