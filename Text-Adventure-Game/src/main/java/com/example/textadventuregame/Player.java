package com.example.textadventuregame;

import com.example.textadventuregame.weapon.Weapon;

public class Player {

    public int hp;
    public Weapon currentWeapon;

    public Player(int hp, Weapon currentWeapon){
        this.hp = hp;
        this.currentWeapon = currentWeapon;
        
    }
}
