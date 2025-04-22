package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.GamePlan;
import cz.vse.adventure.logic.items.Backpack;
import cz.vse.adventure.logic.items.Item;

public class CommandPick implements ICommand {

    private static final String NAME = "pick";

    private GamePlan gamePlan;
    private Backpack backpack;

    public CommandPick(GamePlan gamePlan, Backpack backpack) {
        this.gamePlan = gamePlan;
        this.backpack = backpack;
    }

    @Override
    public String executeCommand(String... params) {
        if (params.length != 1) {
            return "Invalid number of arguments! Usage: pick <item_name>";
        }

        Item item = this.gamePlan.getCurrentRoom().getItemByName(params[0]);

        if (item != null) {
            try {
                this.backpack.storeItem(item, this.gamePlan.getCurrentRoom());
                return "You picked " + item.getName();
            } catch (Exception e) {
                return e.getMessage();
            }
        } else {
            return "There is no such item!";
        }

    }

    @Override
    public String getName() {
        return NAME;
    }
}
