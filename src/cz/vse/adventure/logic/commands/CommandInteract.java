package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.GamePlan;
import cz.vse.adventure.logic.entities.Entity;

public class CommandInteract implements ICommand {

    private static final String NAME = "interact";
    public GamePlan plan;

    public CommandInteract(GamePlan plan) {
        this.plan = plan;
    }

    @Override
    public String executeCommand(String... params) {
        if (params.length != 1) {
            return "You need to specify with which entity you want to interact. Usage: interact <entity_name>";
        }

        Entity entity = plan.getCurrentRoom().getEntityByName(params[0]);

        if (entity == null) {
            return "There is no entity with name " + params[0];
        }

        return entity.interact();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
