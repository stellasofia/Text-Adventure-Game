package com.example.textadventuregame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;


public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start-menu.fxml"))); //to create root node
            Scene scene = new Scene(root);//add root to Scene
            stage.setScene(scene); //add scene to stage
            stage.show();

            stage.setTitle("Text Adventure Game");
            stage.setResizable(false);//size is determined in Scene Builder
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);

    }
}