package com.example.textadventuregame;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToStartMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("start-menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow(); //get source of the event and cast it to a node
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToGame(ActionEvent event) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow(); //get source of the event and cast it to a node
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
