package cz.vse.adventure.logic.entities;

import cz.vse.adventure.logic.Room;
import cz.vse.adventure.logic.items.Item;

import java.util.function.Function;
import java.util.function.Supplier;

public class Prop extends Entity {

    public Prop(String name, String descripton, Function<Item, String> onUse, Supplier<String> onInterract) {
        super(name, descripton, onUse, onInterract);

    }

    public Prop(String name, String descripton, Supplier<String> onInterract, Room currentRoom) {
        super(name, descripton, onInterract);

    }

    public Prop(String name, String descripton, Function<Item, String> onUse, Room currentRoom) {
        super(name, descripton, onUse);

    }

    public Prop(String name, String descripton, Room currentRoom) {
        super(name, descripton);

    }

    @Override
    public String applyItem(Item item) {
        return this.onUse.apply(item);
    }
}
