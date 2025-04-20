package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.GamePlan;
import cz.vse.adventure.logic.entities.Entity;

public class CommandInteract implements ICommand {

    private static final String NAME = "interract";
    public GamePlan plan;

    public CommandInteract(GamePlan plan) {
        this.plan = plan;
    }

    @Override
    public String executeCommand(String... params) {
        if (params.length != 1) {
            return "You need to specify with which entity you want to interact: interact <entity name>";
        }

        Entity entity = plan.getCurrentRoom().getObstacleByName(params[0]);

        if (entity == null) {
            return "There is no entity with name " + params[0];
        }

        return "";
    }

    @Override
    public String getName() {
        return NAME;
    }
}
