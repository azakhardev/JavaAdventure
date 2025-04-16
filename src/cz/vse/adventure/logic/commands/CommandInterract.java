package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.GamePlan;
import cz.vse.adventure.logic.Room;

public class CommandInterract implements ICommand {

    private static final String NAME = "interract";
    public GamePlan plan;

    public CommandInterract(GamePlan plan) {
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
