package com.davity.ipa;

import com.davity.ipa.Controllers.Proveedores;
import com.davity.ipa.Models.Persona;
import com.davity.ipa.Models.Proveedor;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.kordamp.bootstrapfx.BootstrapFX;
import javafx.collections.FXCollections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends Application {
    private static Stage stageView;
    private static Stage stageRoot;
    private static int notificar;

    private static ArrayList<String> productname = new ArrayList<>();
    private static ArrayList<Integer> productquantity = new ArrayList<>();
    private static ArrayList<String> productclasification = new ArrayList<>();
    private static ArrayList<String> productmark = new ArrayList<>();

    public static boolean addNombres(String nombre){
        return productname.add(nombre);
    }

    public static boolean addCantidades(String cantidad){
        return productquantity.add(Integer.valueOf(cantidad));
    }

    public static boolean addClasificaciones(String clasificacion){
        return productclasification.add(clasificacion);
    }

    public static boolean addMarks(String marca){
        return productmark.add(marca);
    }

    public static ArrayList<String> getProductnames() {
        return productname;
    }

    public static ArrayList<Integer> getProductquantitys() {
        return productquantity;
    }

    public static ArrayList<String> getProductclasifications() {
        return productclasification;
    }

    public static ArrayList<String> getProductmark() {
        return productmark;
    }

    @Override
    public void start(Stage stage) throws IOException {
        stageRoot = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("InicioSesion.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setTitle("Inventario de Productos Alimenticios (IPA) - Iniciar sesión");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);

        Image image = new Image(getClass().getResourceAsStream("/logo/caja.png"));
        stage.getIcons().add(image);


        stage.show();

    }

    public static void newStage(String fxml, String title) {
        stageView = new Stage();
        Scene scene = null;

        try {
            scene = new Scene(loadFXML(fxml));
            scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
            stageView.setTitle(title);
            stageView.setScene(scene);
            stageView.centerOnScreen();
            stageView.initOwner(stageRoot);
            stageView.initModality(Modality.APPLICATION_MODAL);
            stageView.showAndWait();
        } catch (IOException ex) {
            //throw new RuntimeException(e);
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Stage getStageView(){
        return stageView;
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {

        launch(args);
    }
}