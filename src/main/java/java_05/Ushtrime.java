package java_05;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Ushtrime extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                Ushtrime.class.getResource("home.fxml")
        );
        Pane loginForm = fxmlLoader.load();
        Scene scene = new Scene(loginForm, 500, 300);
        stage.setScene(scene);
        stage.show();
    }
}
