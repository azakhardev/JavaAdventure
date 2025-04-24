package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.GamePlan;
import cz.vse.adventure.logic.entities.Prop;

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

        Prop prop = plan.getCurrentRoom().getEntityByName(params[0]);

        if (prop == null) {
            return "There is no entity with name " + params[0];
        }

        return prop.interact();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
