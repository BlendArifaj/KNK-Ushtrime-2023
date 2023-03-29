package java_04;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ushtrime_02 extends Application {

    int step = 1;

    @Override
    public void start(Stage stage) throws Exception {
//        Circle circle = new Circle(100, 100, 50);
//        Pane pane = new Pane(circle);
//        Scene scene = new Scene(pane, 500, 500);
//
//        // Eventi:
//
//        EventHandler<ActionEvent> event = (e) -> {
//            double centerX = circle.getCenterX();
//
//            if(centerX >= 450){
//                step = -1;
//            }else if(centerX <= 50){
//                step = 1;
//            }
//           circle.setCenterX(centerX + step);
////           circle.setCenterY();
////            pane.getChildren().clear();
////            pane.getChildren().add(circle);
//        };
//        KeyFrame frame = new KeyFrame(Duration.millis(10), event);
//        Timeline animation = new Timeline(frame);
//        animation.setCycleCount(-1);
//        animation.play();

        MyAnimation myAnimation = new MyAnimation();
        myAnimation.setWidth(500);
        myAnimation.setHeight(500);
        Scene scene = new Scene(myAnimation, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}

class MyAnimation extends Pane {
    private EventHandler<ActionEvent> event = (e) -> {
        this.animationHandler();
    };
    private KeyFrame keyFrame;
    private Timeline animation;
    private double stepX;
    private double stepY;
    private Circle circle;

    public MyAnimation(){
        super();
        this.keyFrame = new KeyFrame(Duration.millis(10), this.event);
        this.animation = new Timeline(this.keyFrame);
        this.stepX = 0;
        this.stepY = 0;
        this.draw();
        this.animation.setCycleCount(Timeline.INDEFINITE);
        this.animation.play();
    }

    private void draw(){
        this.circle = new Circle(50, 50, 50);
        this.getChildren().clear();
        this.getChildren().add(this.circle);
    }

    private void animationHandler(){
        double maxPositionX = super.getWidth();
        double maxPositionY = super.getHeight();
        double circleX = this.circle.getCenterX();
        double circleY = this.circle.getCenterY();

        if(circleX <= 50 && circleY <= 50){
            this.stepX = 0;
            this.stepY = 1;
        } else if (circleY >= maxPositionY && circleX <= 50) {
            this.stepX = 1;
            this.stepY = 0;
        } else if (circleX >= maxPositionX && circleY >= maxPositionY) {
            this.stepX = -1;
            this.stepY = -1;
        }
//        if(circleX >= maxPositionX){
//            this.step = -1;
//        }else if(circleX <= 0){
//            this.step = 1;
//        }
        this.circle.setCenterX(circleX + this.stepX);
        this.circle.setCenterY(circleY + this.stepY);
//        this.circle.setCenterY(circleX + this.step);
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
