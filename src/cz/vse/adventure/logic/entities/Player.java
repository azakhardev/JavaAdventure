package cz.vse.adventure.logic.entities;

import cz.vse.adventure.logic.items.Backpack;

public class Player {
    //private int health = 5;

    private Backpack backpack;

    //private boolean dead = false;

    public Player(Backpack backpack) {
        this.backpack = backpack;
    }

    public Backpack getBackpack() {
        return this.backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    //public int getHealth() {
    //    return health;
    //}

//    public void changeHealth(int health) {
//        if (this.dead) {
//            return;
//        }
//
//        this.health += health;
//        if (this.health > 5) {
//            this.health = 5;
//        }
//
//        if (this.health <= 0) {
//            this.dead = true;
//        }
//    }
}
