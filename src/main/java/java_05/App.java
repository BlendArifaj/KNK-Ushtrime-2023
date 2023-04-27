package java_05;

import com.example.knk_grupi_03_ushtrime.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;


public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // set default locale to English
        Locale.setDefault(new Locale("de", "KS"));

        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("view.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setScene(scene);
        stage.show();
    }
}

