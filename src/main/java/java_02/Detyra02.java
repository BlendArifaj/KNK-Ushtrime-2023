package java_02;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// Different panes
public class Detyra02 extends Application {

    public void start(Stage stage) throws Exception{
        Circle circle = new Circle(100, 100, 100);
        Rectangle rect = new Rectangle(500, 500, 50, 200);
//        Pane pane;
        // Pane
//        pane = new Pane(circle, rect);

        // StackPane
//        pane = new StackPane(circle, rect);
//        pane.getChildren().addAll(circle, rect);

        // FlowPane
//        FlowPane pane = new FlowPane(circle, rect);
//        pane.setOrientation(Orientation.VERTICAL);

        // VBox
//        VBox pane = new VBox(circle, rect);

        // HBox
        HBox pane = new HBox(circle, rect);

//        O
        Scene scene = new Scene(pane, 500, 500);

        stage.setScene(scene);
        stage.show();


    }
}
