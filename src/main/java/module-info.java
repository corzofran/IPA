module com.davity.ipa {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.davity.ipa to javafx.fxml;
    exports com.davity.ipa;
    exports com.davity.ipa.Controllers;
    opens com.davity.ipa.Controllers to javafx.fxml;
}