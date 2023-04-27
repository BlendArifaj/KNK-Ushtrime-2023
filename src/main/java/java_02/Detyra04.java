package java_02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

// Polygon | Polyline
public class Detyra04 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Polygon polygon;
        Pane pane = new Pane();

        for(int i = 0; i < 4; i++){
            polygon = new Polygon(10, 10, 110, 10, 60, 110);
            polygon.setRotate(i * 90);
            polygon.setFill(Color.BLUE);
            polygon.setStroke(Color.WHITE);
            polygon.setStrokeWidth(10);
            pane.getChildren().add(polygon);
        }
//        Polyline polyline = new Polyline(10, 10, 10, 110, 110, 10);

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
