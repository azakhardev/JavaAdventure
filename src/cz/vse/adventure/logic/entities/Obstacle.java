package cz.vse.adventure.logic.entities;

import cz.vse.adventure.logic.Room;
import cz.vse.adventure.logic.commands.UseResult;
import cz.vse.adventure.logic.items.Item;

import java.util.function.Function;

public class Obstacle extends Prop {

    private Room blockedRoom;

    public Obstacle(String name, String descripton, Function<Item, UseResult> onUse, Room room) {
        super(name, descripton, onUse);
        this.blockedRoom = room;
    }

    public Room getBlockedRoom() {
        return blockedRoom;
    }

    public void clearPath() {
        this.blockedRoom = null;
    }
}
