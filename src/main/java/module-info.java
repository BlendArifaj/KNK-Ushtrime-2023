module nje_emer_te_modulit {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.example.knk_grupi_03_ushtrime to javafx.fxml;
    opens java_05 to javafx.fxml;

    opens controllers;
    exports controllers;

    exports com.example.knk_grupi_03_ushtrime;
    exports java_02 to javafx.graphics;
    exports java_03 to javafx.graphics;
    exports java_04 to javafx.graphics;
    exports java_05 to javafx.graphics;
}