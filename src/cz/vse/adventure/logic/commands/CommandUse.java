package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.GamePlan;
import cz.vse.adventure.logic.entities.Entity;
import cz.vse.adventure.logic.entities.Player;
import cz.vse.adventure.logic.items.Backpack;
import cz.vse.adventure.logic.items.Item;

public class CommandUse implements ICommand {

    private static final String NAME = "use";
    private GamePlan plan;
    private Backpack backpack;

    public CommandUse(GamePlan plan, Backpack backpack) {
        this.plan = plan;
        this.backpack = backpack;
    }

    @Override
    public String executeCommand(String... params) {
        if (params.length != 2) {
            return "You need to enter two parameters! Usage: interact <item_name> <entity_name>";
        }

        Item item = backpack.getItemWithName(params[0]);
        Entity entity = plan.getCurrentRoom().getEntityByName(params[1]);

        if (item == null) {
            return "You do not have an item in backpack with that name. Use command inventory to display your carried items. ";
        }

        if (entity == null) {
            return "There is no such entity in the room. Use command look_around to see entities in the room.";
        }

        String result = item.useItem(entity);

        if (!result.contains("can't")) {
            backpack.deleteItem(item);
        }

        return result;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
