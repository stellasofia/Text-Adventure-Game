package com.example.textadventuregame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Group root = new Group();
        Scene scene = new Scene(root,600,600, Color.BLACK);//add root to Scene
        stage.setResizable(false);

        stage.setTitle("Text Adventure Game");

        Text text = new Text(); //type of node needs to be added to a root node
        text.setText("ADVENTURE");
        //position - starting and ending coordinates
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Veranda", 50));
        text.setFill(Color.WHITE);

        Line line = new Line(); //its a node
        line.setStartX(0);
        line.setStartY(400);
        line.setEndX(600);
        line.setEndY(400);
        line.setStrokeWidth(5);
        line.setStroke(Color.WHITE);



        root.getChildren().add(text); //to display text
        root.getChildren().add(line); // to display line
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }
}