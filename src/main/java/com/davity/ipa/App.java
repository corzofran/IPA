package com.davity.ipa;

import com.davity.ipa.Controllers.Empleados;
import com.davity.ipa.Models.Empleado;
import com.davity.ipa.Models.Persona;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.kordamp.bootstrapfx.BootstrapFX;


import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends Application {
    private static Stage stageView;
    private static Stage stageRoot;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("InicioSesion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Inventario de Productos Alimenticios (IPA)" +
                "                                                                                                     Iniciar sesion");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        stage.setResizable(false); //QUITAR LOS ESTIRAMIENTOS

        Image image = new Image(getClass().getResourceAsStream("/logo/caja.png"));
        stage.getIcons().add(image);

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
        launch();
    }
}