package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.GamePlan;
import cz.vse.adventure.logic.Room;
import cz.vse.adventure.logic.entities.Player;
import cz.vse.adventure.logic.items.Backpack;
import cz.vse.adventure.logic.items.Item;

public class CommandDrop implements ICommand {

    private final static String NAME = "drop";
    private final GamePlan gamePlan;
    private final Backpack backpack;

    public CommandDrop(GamePlan gamePlan, Backpack backpack) {
        this.gamePlan = gamePlan;
        this.backpack = backpack;
    }

    @Override
    public String executeCommand(String... params) {

        if (params.length != 1) {
            return "What do you want to drop? Usage: drop <item_name>";
        }

        Room currentRoom = gamePlan.getCurrentRoom();
        Item item = backpack.getItemWithName(params[0]);

        if (item == null) {
            return "You don't have this item.";
        }

        currentRoom.addItem(item);

        return "You dropped the " + item.getName() + " in room " + currentRoom.getName();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
