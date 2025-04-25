package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.items.Backpack;
import cz.vse.adventure.logic.items.Item;

import java.util.Arrays;

public class CommandCombine implements ICommand {

    private final static String NAME = "combine";
    private final Backpack backpack;

    public CommandCombine(Backpack backpack) {
        this.backpack = backpack;
    }

    @Override
    public String executeCommand(String... params) {
        if (params.length != 2) {
            return "What do you want to combine? Usage: combine <item_name> <item_name>";
        }

        Item item1 = backpack.getItemWithName(params[0]);
        Item item2 = backpack.getItemWithName(params[1]);

        if (item1 != null && item2 != null) {
            Item newItem = new Item("", "", 0);
            boolean crafted = false;

            if (Arrays.asList(params).contains("acid") && Arrays.asList(params).contains("bottle")) {
                crafted = true;
                newItem = new Item("acid_bottle", "A carefully filled glass bottle, now holding a dangerous acid. Handle with caution.", 3);
            }

            if (Arrays.asList(params).contains("tape") && Arrays.asList(params).contains("broken_cable")) {
                crafted = true;
                newItem = new Item("sheathed_cable", "A once-split cable now firmly held together with layers of thick tape. It should be safe to use—for now.", 2);
            }

            if (Arrays.asList(params).contains("cloth") && Arrays.asList(params).contains("needle")) {
                this.backpack.deleteItem(item1);
                this.backpack.deleteItem(item2);
                return "You've crafted a hand-stitched fabric extension for your backpack. It’s rough, but it holds together well enough to carry more gear." + backpack.addCapacity(1);
            }

            if (Arrays.asList(params).contains("matches") && Arrays.asList(params).contains("dynamite")) {
                crafted = true;
                newItem = new Item("primed_explosive", "A bundle of aged sticks of dynamite with a fuse attached. Needs to be ignited to detonate—best used carefully at the right spot.", 3);
            }

            if (crafted) {
                this.backpack.deleteItem(item1);
                this.backpack.deleteItem(item2);
                this.backpack.storeItem(newItem);
                return "You crafted new item:" + newItem.getName() + " - " + newItem.getDescription();
            }

        } else {
            return "You don't have those items in your backpack.";
        }

        return "You can't combine those items.";
    }

    @Override
    public String getName() {
        return NAME;
    }
}
