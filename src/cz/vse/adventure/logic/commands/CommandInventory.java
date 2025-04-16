package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.GamePlan;

public class CommandInventory implements ICommand {

    private static final String NAME = "inventory";
    private GamePlan plan;

    public CommandInventory(GamePlan plan) {
        this.plan = plan;
    }

    @Override
    public String executeCommand(String... params) {

        return "";
    }

    @Override
    public String getName() {
        return NAME;
    }
}
