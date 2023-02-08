package com.example.textadventuregame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Story {
    @FXML
    Label dialog, HP, weapon;
    @FXML
    Button choice1, choice2, choice3;
    String position = "Crossroad";
    Player player = new Player(15, new Knife());
    Enemy goblin = new Goblin();
    boolean ring = false;

    //Different button functions depending on location
    @FXML
    void buttonPressed1(ActionEvent event) {
        HP.setText("" + player.hp);
        weapon.setText("" + player.currentWeapon.weaponName);
        switch(position){
            case "Lake": drink(); break;
            case "Cave":
                if(goblin.hp > 0){
                    attackGoblin();
                    break;
                } break;
            case "Gate": talkGuard(); break;
            case "Game Over": break;
            default: gate(); break;
        }
    }
    @FXML
    void buttonPressed2(ActionEvent event) {
        HP.setText("" + player.hp);
        weapon.setText("" + player.currentWeapon.weaponName);
        switch(position){
            case "Lake": lookAround(); break;
            case "Cave":
                if(goblin.hp > 0){
                    talkGoblin();
                }
                break;
            case "Gate": attackGuard(); break;
            case "Game Over": break;
            case "Crossroad": lake(); break;
        }
    }
    @FXML
    void buttonPressed3(ActionEvent event) {
        HP.setText("" + player.hp);
        weapon.setText("" + player.currentWeapon.weaponName);
        switch(position) {
            case "Game Over": break;
            case "Crossroad": cave(); break;
            default:  crossRoad(); break;
        }
    }
    //GATE
    public void gate(){
        position = "Gate";
        if(!ring){
            dialog.setText("Hello Stranger! I don't know you. I cant let you enter town.");
            choice1.setText("Talk to guard");
            choice2.setText("Attack guard");
            choice3.setText("leave");
        } else{
            position = "Game Over";
            dialog.setText("Thank you for slaying the Goblin. You are a true hero! \n\n END");
            choice1.setText("");
            choice2.setText("");
            choice3.setText("");
        }
    }
    public void talkGuard(){
        dialog.setText("Sorry, but there is nothing I can do for you.");
    }
    public void attackGuard(){
        dialog.setText("You took 10 damage!\n That's quite dumb. Don't do that again.");
        player.hp = player.hp - 10;
        HP.setText("" + player.hp);
        if (player.hp <= 0){
            gameOver();
        }
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
        dialog.setText("You found a Sword!");
        player.currentWeapon = new Sword();
        weapon.setText("" + player.currentWeapon.weaponName);
    }
    //CAVE
    public void cave() {
        position = "Cave";
        if (player.hp > 0 && goblin.hp > 0) {
            dialog.setText("You encountered a Goblin!");
            choice1.setText("attack");
            choice2.setText("talk to Goblin");
            choice3.setText("run");
        } else if (goblin.hp <= 0){
            dialog.setText("There is nothing more to do here.");
            choice1.setText("");
            choice2.setText("");
            choice3.setText("leave");
        } else{
            gameOver();
        }
    }
    public void attackGoblin(){
        if(goblin.hp > 0){
            playerAttack();
            HP.setText(player.hp + "");}
        if (goblin.hp <= 0){
            dialog.setText("The Goblin dropped an Item!\nYou obtained a ring. ");
            choice1.setText("");
            choice2.setText("");
            choice3.setText("leave");
            ring = true;
        }
        if(player.hp <= 0){
            gameOver();
        }
    }
    public void talkGoblin(){
        //toDo: if you would understand Goblin outcome would be different.
        dialog.setText("fghjklssösah hdjksa  ... ");
    }

    public void playerAttack(){
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
        goblin.hp = goblin.hp - playerDamage;

        int enemyDamage = new java.util.Random().nextInt(goblin.damage);
        player.hp = player.hp - enemyDamage;

        dialog.setText("You attacked the Goblin and inflicted " + playerDamage + " damage. The Goblin inflicted "+enemyDamage+ " damage." +"\nGoblin HP: " +  goblin.hp);
    }
    //CROSSROAD
    public void crossRoad(){
        position = "Crossroad";
        dialog.setText("You are back at the crossroad.");
        choice1.setText("Head north");
        choice2.setText("Head south");
        choice3.setText("Head west");
    }

    public void gameOver(){
        position = "Game Over";
        dialog.setText("GAME OVER");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
    }
}