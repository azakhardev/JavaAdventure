package cz.vse.adventure.logic.entities;

import cz.vse.adventure.logic.Room;
import cz.vse.adventure.logic.items.Item;

import java.util.function.Function;

public class Prop extends Entity {

    private Room currentRoom;


    public Prop(String name, String descripton, Function<Item, String> onUse, Room currentRoom) {
        super(name, descripton, onUse);
        this.currentRoom = currentRoom;
    }

    @Override
    public String interact() {
        return "";
    }

    @Override
    public String applyItem(Item item) {
        return this.onUse.apply(item);
    }
}
