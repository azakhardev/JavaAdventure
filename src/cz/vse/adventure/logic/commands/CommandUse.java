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
            return "Enter two parameters - what to use and on what you want to use it.";
        }

        Item item = player.getBackpack().getItemWithName(params[0]);
        Entity entity = plan.getAktualniProstor().getEntityWithName(params[1]);

        if (item == null) {
            return "You do not have a backpack item with that name.";
        }

        if (entity == null) {
            return "You do not have a backpack item with that name.";
        }

        item.useItem(entity);

        return "";
    }

    @Override
    public String getName() {
        return NAME;
    }
}
