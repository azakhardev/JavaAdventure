package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.GamePlan;
import cz.vse.adventure.logic.Room;
import cz.vse.adventure.logic.entities.Prop;
import cz.vse.adventure.logic.entities.Obstacle;
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
        StringBuilder obstacles = new StringBuilder("that something is blocking your way to other rooms: ");
        StringBuilder items = new StringBuilder("some items that you can get use of: ");
        StringBuilder props = new StringBuilder("different objects that have caught your eye: ");

        for (Obstacle obstacle : currentRoom.getObstacles().values()) {
            obstacles.append(obstacle.getName()).append(", ");
        }

        if (currentRoom.getObstacles().isEmpty()) {
            obstacles = new StringBuilder();
        } else {
            obstacles.append("\n");
        }

        for (Item item : currentRoom.getItems().values()) {
            items.append(item.getName()).append(", ");
        }

        if (currentRoom.getItems().isEmpty()) {
            items = new StringBuilder();
        } else {
            items.append("\n");
        }

        for (Prop prop : currentRoom.getProps().values()) {
            props.append(prop.getName()).append(", ");
        }

        if (currentRoom.getProps().isEmpty()) {
            props = new StringBuilder();
        }

        return "You are looking around in room " + currentRoom.getName() + " and you see "
                + obstacles + items + props;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
