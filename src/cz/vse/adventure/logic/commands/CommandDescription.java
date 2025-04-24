package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.GamePlan;
import cz.vse.adventure.logic.entities.Prop;

import java.util.Arrays;

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

        if (params.length == 1) {
            Prop p = gamePlan.getCurrentRoom().getEntityByName(params[0]);
            if (p != null) {
                return p.getDescription();
            } else {
                return "There is no such object in this room.";
            }
        }

        return "Command 'description' takes none of the parameters for description of the room and one for description of the object.";

    }

    @Override
    public String getName() {
        return NAME;
    }
}
