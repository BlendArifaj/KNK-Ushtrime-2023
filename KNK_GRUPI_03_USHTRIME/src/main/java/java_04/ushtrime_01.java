package java_04;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class ushtrime_01 extends Application {

    @Override
    public void start(Stage stage) throws Exception{
//        Circle circle = new Circle(100, 100, 100);
//        Pane pane = new Pane(circle);
//
////        Krijimi i eventit
//        EventHandler<ActionEvent> circleEvent = (e) -> {
//           pane.getChildren().clear();
//           circle.setCenterX(circle.getCenterX() + 1);
//           circle.setCenterY(circle.getCenterY() + 1);
//           circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
//           pane.getChildren().add(circle);
//        };
////      Nderlidhja e shkaktimit te eventit me kohen
//        KeyFrame frame = new KeyFrame(Duration.millis(10), circleEvent);
//
////      Krijimi i animacionit
//        Timeline animation = new Timeline(frame);
//
//        //Timeline.INDEFINITE
//        animation.setCycleCount(Timeline.INDEFINITE);
//        animation.play();

        Animation animation = new Animation();
        animation.setWidth(500);
        animation.setHeight(500);
        animation.start();

        Scene scene = new Scene(animation, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}

class Animation extends Pane {

    private EventHandler<ActionEvent> event = (e) -> {
        if(this.x == this.getWidth()){
            this.step = -1;
        } else if (this.x == 0) {
            this.step = 1;
        }
        this.x += this.step;
        this.draw();
    };


    KeyFrame keyFrame = new KeyFrame(Duration.millis(10), this.event);
    Timeline animation = new Timeline(keyFrame);
    private double x = 100;
    private double y = 100;
    private double step = 10;

    public Animation(){
        super();
        this.draw();
    }

    public void setWidth(double width){
        super.setWidth(width);
        this.draw();
    }

    public void setHeight(double height){
        super.setHeight(height);
        this.draw();
    }

    private void draw(){
        Circle circle = new Circle(this.x, this.y, 50);
        circle.setFill(null);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(10);

        this.getChildren().clear();
        this.getChildren().add(circle);
    }

    public void start(){
        this.animation.setCycleCount(-1);
        this.animation.play();
    }

    public void stop(){
        this.animation.stop();
    }

}
