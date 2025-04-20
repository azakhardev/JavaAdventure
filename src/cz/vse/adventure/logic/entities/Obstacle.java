package cz.vse.adventure.logic.entities;

import cz.vse.adventure.logic.Room;
import cz.vse.adventure.logic.items.Item;

public class Obstacle extends Entity {

    private Room blockedRoom;

    public Obstacle(String name, String descripton, Room room) {
        super(name, descripton);
        this.blockedRoom = room;
    }

    public Room getBlockedRoom() {
        return blockedRoom;
    }

    @Override
    public String interact() {
        return "You can't go to the " + blockedRoom.getName() + " beacuse " + this.getName() + "is blocking your way.";
    }

    @Override
    public String applyItem(Item item) {
        return "";
    }
}
