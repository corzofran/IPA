package com.davity.ipa.Controllers;

import com.davity.ipa.App;
import com.davity.ipa.Models.Producto;
import com.davity.ipa.Models.Objetos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductosAdministrador implements Initializable {

    @FXML
    private ImageView beneficiario;

    @FXML
    private ImageView cancelar;

    @FXML
    private ImageView empleado;

    @FXML
    private ImageView inicio;

    @FXML
    private ImageView proveedor;

    @FXML
    private ImageView inventario;

    @FXML
    private ImageView btnAnadirProducto;

    @FXML
    private ImageView btneliminarProducto;

    @FXML
    private ImageView btnmodificarProducto;

    @FXML
    private TableView<Objetos> tablaProductos;

    @FXML
    private TableColumn<Objetos, ?> columnaCantidad;

    @FXML
    private TableColumn<Objetos, ?> columnaClasificacion;

    @FXML
    private TableColumn<Objetos, ?> columnaNombre;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtcantidad;

    @FXML
    private TextField txtclasificacion;

    private ObservableList<Objetos> Productos = FXCollections.observableArrayList();

    Objetos products = new Objetos();
    private ValidationSupport validationSupport;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Productos = FXCollections.observableArrayList();
        tablaProductos.setItems(Productos);

        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        columnaClasificacion.setCellValueFactory(new PropertyValueFactory<>("clasificacion"));

        txtcantidad.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue.matches("\\d*")|| "0".equals(newValue)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Solo puedes ingresar números en la cantidad");
                alert.showAndWait();
                txtcantidad.setText(oldValue);
            }
        });

        validationSupport = new ValidationSupport();
        Validator<String> nombreValidator = Validator.createEmptyValidator("El nombre del producto es requerido");
        Validator<Integer> cantidadValidator = Validator.createEmptyValidator("La cantidad debe ser un número entero");
        Validator<String> clasificacionValidator = Validator.createEmptyValidator("La clasificación es requerida");

        validationSupport.registerValidator(txtNombre, true, nombreValidator);
        validationSupport.registerValidator(txtcantidad, true, cantidadValidator);
        validationSupport.registerValidator(txtclasificacion, true, clasificacionValidator);
    }
    @FXML
    void onClickAnadirProducto(MouseEvent event) {
        String product = this.txtNombre.getText();
        String quanty = this.txtcantidad.getText();
        String clasification = this.txtclasificacion.getText();
        boolean vacio = false;
        Objetos p = new Objetos(product, quanty, clasification);

        Productos.add(p);

        if (validationSupport.isInvalid()) {
            tablaProductos.getItems().clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de validación");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, complete todos los campos de texto.");
            alert.showAndWait();
        } else {
            products.addNombres(txtNombre.getText());
            products.addCantidades(txtcantidad.getText());
            products.addClasificaciones(txtclasificacion.getText());
            int positionModified = Productos.indexOf(p);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("AGREGADO");
            alert.setHeaderText(null);
            alert.setContentText("Producto agregado ✔");
            alert.showAndWait();
            txtNombre.clear();
            txtcantidad.clear();
            txtclasificacion.clear();

            System.out.println(product);
            System.out.println(quanty);
            System.out.println(clasification);
            System.out.println("pos: "+positionModified);
        }
    }

    @FXML
    void onClickSeleccionarTabla(MouseEvent event) {
        Producto p = this.tablaProductos.getSelectionModel().getSelectedItem();
        if(p !=null){
            this.txtNombre.setText(p.getNombre());
            this.txtcantidad.setText(String.valueOf(p.getCantidad()));
            this.txtclasificacion.setText(p.getClasificacion());
        }
    }

    @FXML
    void onClickmodificarProducto(MouseEvent event) {
        Producto p = this.tablaProductos.getSelectionModel().getSelectedItem();

        if(p ==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor seleccione un producto");
            alert.showAndWait();
        }else {
            try{
                String product = this.txtNombre.getText();
                String quanty = this.txtcantidad.getText();
                String clasification = this.txtclasificacion.getText();

                Producto pro = new Producto(product, quanty, clasification);

                if(!this.Productos.contains(pro)){
                    p.setNombre(pro.getNombre());
                    p.setCantidad(pro.getCantidad());
                    p.setClasificacion(pro.getClasificacion());

                    this.tablaProductos.refresh();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Modificado");
                    alert.setHeaderText(null);
                    alert.setContentText("Producto modificado ✔");
                    alert.showAndWait();

                    //DECLARANDO OTRA VEZ LOS VALORES QUE HAY EN LOS TEXTFIELD EN VARIABLES
                    String ProductoElement = txtNombre.getText();
                    int QuantyElement = Integer.parseInt(txtcantidad.getText());
                    String ClasificationElement = txtclasificacion.getText();

                    int positionModified = Productos.indexOf(p);

                    System.out.println("mod: "+positionModified);
                    System.out.println(ProductoElement);
                    System.out.println(QuantyElement);
                    System.out.println(ClasificationElement);

                    //Llamando los arraysList de Producto para modificarlos tambien
                    ArrayList<String> nameProducto = Objetos.getProductnames();
                    ArrayList<Integer> QuantyProducto = Objetos.getProductquantitys();
                    ArrayList<String> ClasificationProducto = Objetos.getProductclasifications();

                    //MODIFICANDO LOS ELEMENTOS ANTIGUOS DE LOS ARRAYSLIST
                    nameProducto.set(positionModified, ProductoElement);
                    QuantyProducto.set(positionModified, QuantyElement);
                    ClasificationProducto.set(positionModified, ClasificationElement);

                    // Agregar el nuevo elemento en la misma posición


                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("El producto ya existe");
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
    void onClickEliminarProducto(MouseEvent event) {
        Producto p = this.tablaProductos.getSelectionModel().getSelectedItem();

        if(p == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor seleccione a un beneficiario");
            alert.showAndWait();
        }else {
            int positionElimined = Productos.indexOf(p);
            System.out.println("P: "+positionElimined);

            //ELIMINA TAMBIEN EL ELEMENTO DEL ARRAYLIST PARA QUE TAMPOCO EXISTA CUANDO SE HAGA LA BUSQUEDA
           ArrayList<String> nameproduct = Objetos.getProductname();
            nameproduct.remove(positionElimined);

            this.Productos.remove(p);
            this.tablaProductos.refresh();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("Producto eliminado");
            alert.showAndWait();
        }
    }
    @FXML
    void onClickBeneficiario(MouseEvent event) {
        App.newStage("Beneficiario", "Tabla de beneficiarios");
    }

    @FXML
    void onClickCancelar(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickEmpleado(MouseEvent event) {
        App.newStage("Empleados","Tabla de empleados");
    }

    @FXML
    void onClickInicio(MouseEvent event) {
        App.newStage("HomeAdministrador","Bienvenido Administrador");
    }

    @FXML
    void onClickProveedor(MouseEvent event) {
        App.newStage("Proveedores","Tabla de proveedores");
    }

}


