module com.example.knk_grupi_03_ushtrime {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.knk_grupi_03_ushtrime to javafx.fxml;
    opens java_05 to javafx.fxml;


    exports com.example.knk_grupi_03_ushtrime;
    exports java_02 to javafx.graphics;
    exports java_03 to javafx.graphics;
    exports java_04 to javafx.graphics;
    exports java_05 to javafx.graphics;


}