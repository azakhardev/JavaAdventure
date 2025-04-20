package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.GamePlan;
import cz.vse.adventure.logic.Room;
import cz.vse.adventure.logic.entities.Entity;
import cz.vse.adventure.logic.items.Item;

public class CommandLookAround implements ICommand {

    private final static String NAME = "look_around";
    private final GamePlan plan;

    public CommandLookAround(GamePlan plan) {
        this.plan = plan;
    }

    @Override
    public String executeCommand(String... params) {

        if (params.length != 0) {
            return "Command look_around does not take any parameters!";
        }

        Room currentRoom = plan.getCurrentRoom();
        String entities = "";
        String items = "";

        for (Entity entity : currentRoom.getObstacles().values()) {
            entities += entity.getName() + "/n";
        }

        for (Item item : currentRoom.getItems().values()) {
            items += item.getName() + "/n";
        }

        return "You are looking around in room " + currentRoom + " and you see: \n"
                + "Those obstacles: " + entities + "\n" + "Those items: " + items + "\n";

    }

    @Override
    public String getName() {
        return NAME;
    }
}
