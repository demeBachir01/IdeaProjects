package com.example.tpcours;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TpCoursEvent extends Application {



    @Override
    public void start(Stage primaryStage) {
        Circle cercle =new Circle();
        cercle.setCenterX(100);
        cercle.setCenterY(100);
        cercle.setRadius(50);
        cercle.setFill(Color.BLUE);
        cercle.setFocusTraversable(true);
        cercle.setOnKeyPressed(keyEvent -> System.out.println("touche enfonce: " +keyEvent.getCode()+" "+keyEvent.getCharacter()));
        cercle.setOnKeyReleased(keyEvent -> System.out.println("Touche relache: " +keyEvent.getCode()+ " " + keyEvent.getCharacter()));
        cercle.setOnKeyTyped(keyEvent -> System.out.println("Touche Touche: " +keyEvent.getCode()+ " " + keyEvent.getCharacter()));
        primaryStage.setTitle("Tp Evenement");
        Pane pane=new Pane();
        pane.getChildren().setAll(cercle);
        Scene scene=new Scene(pane,240,180,Color.AQUAMARINE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
