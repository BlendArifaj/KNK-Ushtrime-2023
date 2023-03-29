package java_02;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Detyra01 extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        // Scene
        // Pane
        // Nodes
        Node text = new Text(100, 100, "Hello World!");

//        Node pane = new Pane();
        Pane pane = new Pane(text);
//        pane.getChildren().add(text);
        Scene scene = new Scene(pane, 250, 250);

        stage.setScene(scene);
        stage.setTitle("Ushtrimet ne KNK");
        stage.show();
    }

}
