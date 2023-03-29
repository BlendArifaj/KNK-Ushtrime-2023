package java_05;

import com.example.knk_grupi_03_ushtrime.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("login.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setScene(scene);
        stage.show();
    }
}
