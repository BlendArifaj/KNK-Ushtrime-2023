package java_05;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Ushtrime2 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                Ushtrime2.class.getResource("login.fxml")
        );
        Pane pane = fxmlLoader.load();
        Scene scene = new Scene(pane, 500, 400);
        stage.setScene(scene);
        stage.show();
    }

}
