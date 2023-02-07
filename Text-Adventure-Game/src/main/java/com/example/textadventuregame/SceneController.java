package com.example.textadventuregame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label dialog, HP, weapon;
    @FXML
    Button choice1, choice2, choice3;

    //private int hp = 15;

//to return to start Menu
/*
    public void switchToStartMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("start-menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow(); //get source of the event and cast it to a node
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
 */

    public void switchToWoods(ActionEvent event) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow(); //get source of the event and cast it to a node
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void display(){
        //TODO: - find out how to change HP if damage is taken.
        //      - change location and implement actions. (Weapon)
        //      - !!! Change action event on button if in different location? is it even possible? Or do I have to create different fxml files and cant reuse the one?
        //HP.setText(hp.toString());
        dialog.setText("You woke up in the middle of the woods.");
        choice1.setText("Go north");
        choice2.setText("Go south");
        choice3.setText("Go west");
        weapon.setText("Knife");
    }

}
