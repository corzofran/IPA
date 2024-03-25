package com.davity.ipa.Controllers;
import javafx.scene.Node;
import javafx.stage.Stage;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.net.URL;
import java.util.ResourceBundle;

import com.davity.ipa.Models.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ProductosEmpleado {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView cancelar;

    @FXML
    private TextField cantidad;

    @FXML
    private TextField clasificacion;

    @FXML
    private ImageView eliminar;

    @FXML
    private ImageView guardar;

    @FXML
    private ImageView inicio;

    @FXML
    private ImageView inventario;

    @FXML
    private TextField nombre;

    @FXML
    void onClickCancelar(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickEliminar(MouseEvent event) {

    }

    @FXML
    void onClickInicio(MouseEvent event) {

    }

    @FXML
    void onClickInventario(MouseEvent event) {

    }

    private Producto producto = new Producto();
    private ValidationSupport validationSupport;

    @FXML
    void initialize() {
        validationSupport = new ValidationSupport();

        Validator<String> nombreValidator = Validator.createEmptyValidator("El nombre del producto es requerido");
        Validator<Integer> cantidadValidator = Validator.createEmptyValidator("La cantidad debe ser un número entero");
        Validator<String> clasificacionValidator = Validator.createEmptyValidator("La clasificación es requerida");

        validationSupport.registerValidator(nombre, true, nombreValidator);
        validationSupport.registerValidator(cantidad, true, cantidadValidator);
        validationSupport.registerValidator(clasificacion, true, clasificacionValidator);

        cantidad.textProperty().addListener((observable, oldValue, newValue) -> {
            // Verificar si el nuevo valor no es un número
            if (!newValue.matches("\\d*")|| "0".equals(newValue)) {
                // Mostrar alerta indicando que solo se pueden ingresar números
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Solo puedes ingresar números en la cantidad");
                alert.showAndWait();
                // Restaurar el valor anterior
                cantidad.setText(oldValue);
            }
        });
    }

    @FXML
    void onClickguardar(MouseEvent event) {
        if (validationSupport.isInvalid()) {
            // Mostrar mensaje de error debido a la validación fallida
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de validación");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, complete todos los campos correctamente.");
            alert.showAndWait();
        } else {
            producto.addNombre(nombre.getText());
            producto.addCantidad(Integer.parseInt(cantidad.getText()));
            producto.addClasificacion(clasificacion.getText());


            // Resto de tu código para agregar el producto y mostrar la alerta de confirmación
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("AGREGADO");
            alert.setHeaderText(null);
            alert.setContentText("Producto agregado ✔");
            alert.showAndWait();
        }
    }



}

