package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.GamePlan;
import cz.vse.adventure.logic.Room;
import cz.vse.adventure.logic.entities.Entity;
import cz.vse.adventure.logic.entities.Prop;
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
        StringBuilder entities = new StringBuilder();
        StringBuilder items = new StringBuilder();
        StringBuilder props = new StringBuilder();

        for (Entity entity : currentRoom.getObstacles().values()) {
            entities.append(entity.getName()).append(",");
        }

        for (Item item : currentRoom.getItems().values()) {
            items.append(item.getName()).append(",");
        }

        for (Prop prop : currentRoom.getProps().values()) {
            props.append(prop.getName()).append(",");
        }

        return "You are looking around in room " + currentRoom.getName() + " and you see: \n"
                + "Those obstacles: " + entities + "\n" + "Those items: " + items + "\n" + "Those objects: " + props;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
