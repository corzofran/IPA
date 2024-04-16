package com.davity.ipa.Controllers;

import com.davity.ipa.App;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PasswordEnviada {

    @FXML
    private Button volver;

    @FXML
    void onClickVolver(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
