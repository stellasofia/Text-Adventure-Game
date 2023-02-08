package com.example.textadventuregame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

//Handles Dialog
public class Story {

    @FXML
    Label dialog, HP, weapon;
    @FXML
    Button choice1, choice2, choice3;


    String position = "Crossroad";
    String choice;
    Player player = new Player(15, new Knife());



    @FXML
    void buttonPressed1(ActionEvent event) {
        HP.setText("" + player.hp);
        weapon.setText("" + player.currentWeapon.weaponName);
        switch(position){
            case "Lake": drink(); break;
            case "Cave": attackGoblin(); break;
            case "Gate": talkGuard(); break;
            default: gate(); break;
        }
    }
    @FXML
    void buttonPressed2(ActionEvent event) {
        HP.setText("" + player.hp);
        weapon.setText("" + player.currentWeapon.weaponName);
        switch(position){
            case "Lake": lookAround(); break;
            case "Cave": talkGoblin(); break;
            case "Gate": attackGuard(); break;
            case "Crossroad": lake(); break;
            default: lake(); break;
        }
    }
    @FXML
    void buttonPressed3(ActionEvent event) {
        HP.setText("" + player.hp);
        weapon.setText("" + player.currentWeapon.weaponName);
        switch(position) {
            case "Lake": crossRoad();break;
            case "Cave": crossRoad(); break;
            case "Gate": crossRoad(); break;
            case "Crossroad": cave(); break;
            default: cave();break;
        }
    }

    /*
    public void defaultSetup(){
        player.hp = 15;
        HP.setText("" + player.hp);
        player.currentWeapon = new Knife(); //currentWeapon = Weapon (superclass)
        weapon.setText("" + player.currentWeapon.weaponName);
    }
     */

    //GATE
    public void gate(){
        //TODO: - find out how to change HP if damage is taken.
        //      - change location and implement actions. (Weapon)
        //      - !!! Change action event on button if in different location? is it even possible? Or do I have to create different fxml files and cant reuse the one?
        position = "Gate";
        dialog.setText("Hello Stranger! I don't know you. I cant let you enter town.");
        choice1.setText("Talk to guard");
        choice2.setText("Attack guard");
        choice3.setText("leave");
       // defaultSetup();
    }
    public void talkGuard(){
        dialog.setText("Sorry, but there is nothing I can do for you.");
    }
    public void attackGuard(){
        dialog.setText("That's quite dumb. Don't do that again.");
        player.hp = player.hp - 10;
        HP.setText("" + player.hp);
    }


    //LAKE
    public void lake(){
        position = "Lake";
        dialog.setText("You found a Lake!");
        choice1.setText("Drink some water");
        choice2.setText("Look around");
        choice3.setText("Leave");
    }
    public void drink(){
        player.hp += 3;
        HP.setText("" + player.hp);
        dialog.setText("You feel refreshed");
        choice1.setText("Drink some water");
        choice2.setText("Look around");
        choice3.setText("Leave");
    }
    public void lookAround(){
        //TODO: change dialog the second: "time to there is nothing more to find."
        dialog.setText("You found a Sword!");
        player.currentWeapon = new Sword();
        weapon.setText("" + player.currentWeapon.weaponName);
    }


    //CAVE
    public void cave(){
        position = "Cave";
        dialog.setText("You encountered a Goblin!");
        choice1.setText("Attack");
        choice2.setText("Talk to the Goblin");
        choice3.setText("Run");
    }
    public void attackGoblin(){
        //TODO: if your or Goblins health below 0 - he drop a ring, you dead -> create new scene for that.
        dialog.setText("You attacked the Goblin. But he thought back!");
        //TODO: create Enemy Class for Goblin and maybe some other random encounters.
        player.hp = player.hp - 2;
        HP.setText(player.hp + "");
    }
    public void talkGoblin(){
        //toDo: if you would understand Goblin outcome would be different.
        dialog.setText("fghjklssösah hdjksa  ... ");
    }


    //CROSSROAD
    public void crossRoad(){
        position = "Crossroad";
        dialog.setText("You are back at the crossroad.");
        choice1.setText("Head north");
        choice2.setText("Head south");
        choice3.setText("Head west");
    }



}