package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.items.Backpack;
import cz.vse.adventure.logic.items.Item;

public class CommandInspect implements ICommand {
    private final static String NAME = "inspect";
    private Backpack backpack;

    public CommandInspect(Backpack backpack) {
        this.backpack = backpack;
    }

    @Override
    public String executeCommand(String... params) {
        if (params.length != 1) {
            return "You need to specify what you want to inspect. Usage: inspect <item_in_inventory>";
        }

        Item item = backpack.getItemWithName(params[0]);

        if (item == null) {
            return "You don't have this item.";
        }

        return item.getDescription();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
