package java_04;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ushtrime_03 extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        AnimationCircle animationCircle = new AnimationCircle();
        Scene scene = new Scene(animationCircle, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}

class AnimationCircle extends Pane {
    private int step;
    Circle circle;
    Shape shape;
    KeyFrame frame;
    Timeline timeline;
    EventHandler<ActionEvent> handleAnimation = (ActionEvent e) -> {
        this.animate();
    };
    public AnimationCircle(){
        this.step = 10;
        this.frame = new KeyFrame(Duration.millis(100), this.handleAnimation);
        this.timeline = new Timeline(this.frame);
        this.timeline.setCycleCount(Timeline.INDEFINITE);
        this.draw();
        this.timeline.play();
    }
    private void draw(){
        this.shape = new Circle(100, 100, 50);
        this.getChildren().clear();
        this.getChildren().add(this.shape);
    }
    private void animate(){
        double width = super.getWidth();
        double height = super.getHeight();
        double circleX = this.circle.getCenterX();
        double circleY = this.circle.getCenterY();

        if(circleX > width || circleY > height){
            this.step = -10;
        }else if(circleX < 0 || circleY < 0){
            this.step = 10;
        }
        this.circle.setCenterX(circleX + this.step);
        this.circle.setCenterY(circleY + this.step);

    }
    public void setWidth(double width){
        super.setWidth(width);
        this.draw();
    }
    public void setHeight(double height){
        super.setHeight(height);
        this.draw();
    }
}
