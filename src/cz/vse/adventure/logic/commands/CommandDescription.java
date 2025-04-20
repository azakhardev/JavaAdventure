package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.GamePlan;

public class CommandDescription implements ICommand {

    private final static String NAME = "description";
    private final GamePlan gamePlan;

    public CommandDescription(GamePlan gamePlan) {
        this.gamePlan = gamePlan;
    }

    @Override
    public String executeCommand(String... params) {

        if (params.length == 0) {
            return gamePlan.getCurrentRoom().getLongDescription();
        }

        return "Command 'description' does not take any parameters.";

    }

    @Override
    public String getName() {
        return NAME;
    }
}
