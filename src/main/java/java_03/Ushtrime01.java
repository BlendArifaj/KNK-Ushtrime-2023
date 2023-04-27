package java_03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Ushtrime01 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//        Polygon pol = new Polygon(0, 0, 100, 100, 100, 0);
        Polyline pol = new Polyline(0, 0, 100, 100, 100, 0);
        pol.setFill(null);
        pol.setStroke(Color.BLUE);
        pol.setStrokeWidth(10);
        pol.setRotate(50);

        //Line line = new Line();
        MyCustomLine line = new MyCustomLine();
        line.setPoints(0,0, 100, 100);

        XLine xLine1 = new XLine();
        xLine1.setWidth(500);
        xLine1.setHeight(500);
        xLine1.setRotate(45);

        XLine xLine2 = new XLine();


        Arc arc = new Arc(100, 100, 100, 100, 0, 50);
        arc.setType(ArcType.ROUND);
        arc.setFill(Color.GREEN);
        arc.setStroke(Color.BLUE);
        arc.setStrokeWidth(10);

        Pane pane = new Pane();
        pane.getChildren().addAll(arc);

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ushtrimet ne KNK");
        primaryStage.show();
    }
}


class MyCustomLine extends Line{
    public void setPoints(double startX,double startY,double endX,double endY){
        this.setStartX(startX);
        this.setStartY(startY);
        this.setEndX(endX);
        this.setEndY(endY);
    }
}

// X

class XLine extends Pane{
    public XLine(){
        super();
        this.draw();
    }

    private void draw(){
        MyCustomLine line1 = new MyCustomLine();
        double width = this.getWidth();
        double height = this.getHeight();

        line1.setPoints(0, 0, width, height);

        MyCustomLine line2 = new MyCustomLine();
        line2.setPoints(width, 0, 0, height);

        this.getChildren().clear();
        this.getChildren().addAll(line1, line2);
    }

    public void setHeight(double height){
        super.setHeight(height);
        this.draw();
    }
    public void setWidth(double width){
        super.setWidth(width);
        this.draw();
    }
}
