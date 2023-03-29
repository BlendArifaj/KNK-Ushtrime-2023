package java_02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

// Detyra: Circle
public class Detyra03 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Circle circle1;
        Circle circle2;
        HBox row1 = new HBox();
        HBox row2 = new HBox();
        VBox table = new VBox(row1, row2);
        for(int i = 0; i < 10; i++){
            circle1 = new Circle(100, 100, 100);
            circle1.setFill(null);
            circle1.setStroke(Color.BLACK);
            circle1.setStrokeWidth(10);
            row1.getChildren().add(circle1);

            circle2 = new Circle(100, 300, 100);
            row2.getChildren().add(circle2);
        }
        Pane pane = new Pane(table);
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
