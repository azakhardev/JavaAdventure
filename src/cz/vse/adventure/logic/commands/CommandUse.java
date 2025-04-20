package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.GamePlan;
import cz.vse.adventure.logic.entities.Entity;
import cz.vse.adventure.logic.entities.Player;
import cz.vse.adventure.logic.items.Item;

public class CommandUse implements ICommand {

    private static final String NAME = "use";
    private GamePlan plan;
    private Player player;

    public CommandUse(GamePlan plan, Player player) {
        this.plan = plan;
        this.player = player;
    }

    @Override
    public String executeCommand(String... params) {
        if (params.length != 2) {
            return "You need to enter two parameters! Usage: interact <item_name> <entity_name>";
        }

        Item item = player.getBackpack().getItemWithName(params[0]);
        Entity entity = plan.getCurrentRoom().getEntityByName(params[1]);

        if (item == null) {
            return "You do not have an item in backpack with that name. Use command inventory to display your carried items. ";
        }

        if (entity == null) {
            return "There is no such entity in the room. Use command look_around to see entities in the room.";
        }

        item.useItem(entity);

        return "You've use " + item.getName() + "on " + entity.getName();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
