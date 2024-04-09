package com.davity.ipa.Controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.net.URL;
import java.util.ArrayList;
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
    private ImageView inicio;

    @FXML
    private ImageView inventario;

    @FXML
    private TextField nombre;

    @FXML
    private TableColumn<Producto, ?> columnaClasificacion;

    @FXML
    private TableColumn<Producto, ?> columnaCantidad;

    @FXML
    private TableColumn<Producto, ?> columnaNombre;

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private ImageView eliminarProducto;

    @FXML
    private ImageView modificar;

    @FXML
    private ImageView guardar;

    private ObservableList<Producto> productos = FXCollections.observableArrayList();

    @FXML
    void onClickCancelar(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickInicio(MouseEvent event) {

    }

    @FXML
    void onClickInventario(MouseEvent event) {

    }
    Producto producto = new Producto();
    private ValidationSupport validationSupport;

    @FXML
    void initialize() {
        productos = FXCollections.observableArrayList();
        tablaProductos.setItems(productos);

        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        columnaClasificacion.setCellValueFactory(new PropertyValueFactory<>("clasificacion"));


        validationSupport = new ValidationSupport();

        Validator<String> nombreValidator = Validator.createEmptyValidator("El nombre del producto es requerido");
        Validator<Integer> cantidadValidator = Validator.createEmptyValidator("La cantidad debe ser un número entero");
        Validator<String> clasificacionValidator = Validator.createEmptyValidator("La clasificación es requerida");

        validationSupport.registerValidator(nombre, true, nombreValidator);
        validationSupport.registerValidator(cantidad, true, cantidadValidator);
        validationSupport.registerValidator(clasificacion, true, clasificacionValidator);

        cantidad.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue.matches("\\d*")|| "0".equals(newValue)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Solo puedes ingresar números en la cantidad");
                alert.showAndWait();

                cantidad.setText(oldValue);
            }
        });
    }

    @FXML
    void onClickguardar(MouseEvent event) {
        //declarar los valores de textfield en variables
        String product = nombre.getText();
        String quanty = cantidad.getText();
        String clasification = clasificacion.getText();

        Producto p = new Producto(product,quanty, clasification);
 //////////////////////////////
        productos.add(p);
/////////////////////////////

        if (validationSupport.isInvalid()) {
            tablaProductos.getItems().clear();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de validación");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, complete todos los campos correctamente.");
            alert.showAndWait();
        } else {
            producto.addNombre(nombre.getText());
            producto.addCantidad(cantidad.getText());
            producto.addClasificacion(clasificacion.getText());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("AGREGADO");
            alert.setHeaderText(null);
            alert.setContentText("Producto agregado ✔");
            alert.showAndWait();
            int positionModified = productos.indexOf(p);
            nombre.clear();
            cantidad.clear();
            clasificacion.clear();
            System.out.println(positionModified);
        }
    }

    @FXML
    void onClickSeleccionarTabla(MouseEvent event) {
        Producto p = this.tablaProductos.getSelectionModel().getSelectedItem();
        if(p !=null){
            this.nombre.setText(p.getNombre());
            this.cantidad.setText(String.valueOf(p.getCantidad()));
            this.clasificacion.setText(p.getClasificacion());
        }

    }

    public void onClickmodificar(MouseEvent mouseEvent) {
        Producto p = this.tablaProductos.getSelectionModel().getSelectedItem();

        if(p ==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor seleccione un producto");
            alert.showAndWait();
        }else {
            try{
                String product = this.nombre.getText();
                String quanty = this.cantidad.getText();
                String clasification = this.clasificacion.getText();

                Producto pro = new Producto(product, quanty, clasification);

                if(!this.productos.contains(pro)){
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
                    String ProductoElement = nombre.getText();
                    int QuantyElement = Integer.parseInt(cantidad.getText());
                    String ClasificationElement = clasificacion.getText();

                    int positionModified = productos.indexOf(p);

                    System.out.println("mod: "+positionModified);
                    System.out.println(ProductoElement);
                    System.out.println(QuantyElement);
                    System.out.println(ClasificationElement);

                    //Llamando los arraysList de Producto para modificarlos tambien
                    ArrayList<String> nameProducto = Producto.getProductname();
                    ArrayList<Integer> QuantyProducto = Producto.getProductquantity();
                    ArrayList<String> ClasificationProducto = Producto.getProductclasification();

                    //MODIFICANDO LOS ELEMENTOS ANTIGUOS DE LOS ARRAYSLIST
                    nameProducto.set(positionModified, ProductoElement);
                    QuantyProducto.set(positionModified, QuantyElement);
                    ClasificationProducto.set(positionModified, ClasificationElement);

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
    void onClickEliminar(MouseEvent event) {
        Producto p = this.tablaProductos.getSelectionModel().getSelectedItem();

        if(p ==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor seleccione a un beneficiario");
            alert.showAndWait();
        }else {
            int positionElimined = productos.indexOf(p);
            System.out.println("P: "+positionElimined);

            //ELIMINA TAMBIEN EL ELEMENTO DEL ARRAYLIST PARA QUE TAMPOCO EXISTA CUANDO SE HAGA LA BUSQUEDA
            ArrayList<String> nameproduct = Producto.getProductname();
            nameproduct.remove(positionElimined);

            this.productos.remove(p);
            this.tablaProductos.refresh();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aviso");
            alert.setHeaderText(null);
            alert.setContentText("Producto eliminado");
            alert.showAndWait();
        }
    }

}

