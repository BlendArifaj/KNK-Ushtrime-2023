package java_03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Ushtrimet02 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Polygon
        // Polyline
        // Rectangle
        // Circle
        // Line
        // Arc
        // ...
        MyCustomPolygon polygon = new MyCustomPolygon(0, 0, 100, 100, 100, 0);
//        Polyline polygon = new Polyline(0, 0, 100, 100, 100, 0);

//        polygon.setFill(null);
//        polygon.setStroke(Color.BLUE);
//        polygon.setStrokeWidth(5);

        polygon.setDetails(null, Color.RED, 5);

        Line line = new Line(0,0, 500, 500);
        line.setFill(Color.GREEN);

        // x, y, r1, r2, start, length
        Arc arc = new Arc(250, 250, 150, 150, 0, 70);
        arc.setType(ArcType.ROUND);
        arc.setFill(null);
        arc.setStroke(Color.GREEN);
        arc.setStrokeWidth(5);

        Pane pane = new Pane(arc);
//        pane.getChildren().add(...);
//        pane.getChildren().addAll(..., ..., ...);


        MyCustomRect rect = new MyCustomRect();
        rect.setWidth(500);
        rect.setHeight(500);

        CustomShape shape = new CustomShape();
        shape.setWidth(1000);
        shape.setHeight(1000);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("KNK Ushtrime");
        primaryStage.show();
    }
}


class MyCustomPolygon extends Polygon {
    public MyCustomPolygon(double... var1){
        super(var1);
    }

    public void setDetails(
            Color fillColor, Color strokeColor, double strokeWidth
    ){
       this.setFill(fillColor);
       this.setStroke(strokeColor);
       this.setStrokeWidth(strokeWidth);
    }

}

class MyCustomRect extends Pane{
    public MyCustomRect(){
       super();
       this.draw();
    }

    private void draw(){
        double width = super.getWidth();
        double height = super.getHeight();

        Rectangle rect = new Rectangle(0,0, width, height);
        rect.setFill(null);
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(1);

        Line line1 = new Line(0, 0, width, height);
        Line line2 = new Line(width, 0, 0, height);

        this.getChildren().clear();
        this.getChildren().addAll(rect, line1, line2);
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

abstract class AbstractPane extends  Pane{
    abstract protected void draw();

    public void setWidth(double width){
        super.setWidth(width);
        this.draw();
    }

    public void setHeight(double height){
        super.setHeight(height);
        this.draw();
    }
}

class CustomShape extends AbstractPane{
    public CustomShape(){
        super();
        this.draw();
    }
    protected void draw(){
        double width = super.getWidth();
        double height = super.getHeight();
        // 0, 0, 0, height, width/2, height/2
        // 0, 0, width, 0, width/2, height/2
        // width, 0, width, height, width/2, height/2
        // width, height, 0, height, width/2, height/2
        Polygon polygon1 = new Polygon(0, 0, 0, height, width/2, height/2);
        polygon1.setFill(Color.RED);
        Polygon polygon2 = new Polygon(0, 0, width, 0, width/2, height/2);
        polygon2.setFill(Color.GREEN);
        Polygon polygon3 = new Polygon(width, 0, width, height, width/2, height/2);
        polygon3.setFill(Color.BLUE);
        Polygon polygon4 = new Polygon(width, height, 0, height, width/2, height/2);
        polygon4.setFill(Color.DARKGRAY);

        this.getChildren().clear();
        this.getChildren().addAll(polygon1, polygon2, polygon3, polygon4);
    }

}