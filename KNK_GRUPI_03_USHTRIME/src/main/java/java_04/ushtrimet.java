package java_04;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

// Animacionet
// Event-i qe do te ekzekutohet
// Koha kur do te perseritet eventi
// Kur do te perfundoj animacioni
// Fillimi i animacionit

public class ushtrimet extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Fan fan = new Fan();
        fan.setWidth(200);
        fan.setHeight(200);
        fan.start();

        Scene scene = new Scene(fan, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


class Fan extends Pane {
    private int time = 0;

    private EventHandler<ActionEvent> event = (e) -> {
        this.increaseTime();
    };

    private KeyFrame frame = new KeyFrame(Duration.millis(10), this.event);
    private Timeline animation = new Timeline(frame);

    private void draw() {
        super.getChildren().clear();

        double radius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(null);
        circle.setStroke(Color.BLACK);
        super.getChildren().add(circle);

        for(int i = 0; i < 4; i++) {
            Arc arc = new Arc();
            arc.setCenterX(centerX);
            arc.setCenterY(centerY);
            arc.setRadiusX(radius - 5);
            arc.setRadiusY(radius - 5);
            arc.setType(ArcType.ROUND);
            arc.setStartAngle(i * 90 + this.time);
            arc.setLength(40);
            arc.setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));
            super.getChildren().add(arc);
        }

    }

    public void start() {
        this.animation.setCycleCount(Timeline.INDEFINITE);
        this.animation.play();
    }

    public void setWidth(double width) {
        super.setWidth(width);
        this.draw();
    }

    public void setHeight(double height) {
        super.setHeight(height);
        this.draw();
    }

    public void createAnimation() {

    }

    private void increaseTime() {
        this.time += 1;
        if(this.time == 360) {
            this.time = 0;
        }
        this.draw();
    }
}


class MyFan extends Pane {
    private int num = 4;

    private void draw() {
        double x,y,radius;
        x = 10 + super.getWidth() / 2;
        y = 10 + super.getHeight() / 2;
        radius = super.getWidth() / 2;

        Circle circle = new Circle(x, y, radius);
        circle.setFill(null);
        circle.setStroke(Color.BLACK);

        Group group = new Group();
        for(int i = 0; i < this.num; i++) {
            double startPosition = 360 / this.num;
            double length = startPosition / 2;
            Arc arc = new Arc(x, y, radius - 10,
                    radius - 10, i * startPosition, length);
            arc.setFill(null);
            arc.setStroke(Color.GREEN);
            arc.setStrokeWidth(3);
            arc.setType(ArcType.ROUND);

            group.getChildren().add(arc);
        }

        super.getChildren().clear();
        super.getChildren().addAll(circle, group);
    }

    public void setWidth(double width) {
        super.setWidth(width);
        super.setHeight(width);
        this.draw();
    }

    public void setNumberOfArcs(int num) {
        this.num = num;
        this.draw();
    }
}