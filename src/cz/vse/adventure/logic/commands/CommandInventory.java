package cz.vse.adventure.logic.commands;

import cz.vse.adventure.logic.entities.Player;
import cz.vse.adventure.logic.items.Backpack;
import cz.vse.adventure.logic.items.Item;

public class CommandInventory implements ICommand {

    private static final String NAME = "inventory";
    private Player player;

    public CommandInventory(Player player) {
        this.player = player;
    }

    /**
     * Příkaz zobrazí obsah batohu hráče
     *
     * @param params nepotřebuje žádné příkazy
     */
    @Override
    public String executeCommand(String... params) {
        Backpack backpack = player.getBackpack();

        if (params.length != 0) {
            return "Command inventory does not take any parameters";
        }

        StringBuilder storedItems = new StringBuilder("You have those items in your backpack: \n");

        for (Item item : backpack.getItems()) {
            storedItems.append(item.getName()).append(" that takes up ").append(item.getVolume()).append(" space unit.\n");
        }

        storedItems.append("You have ").append(backpack.getCapacity() - backpack.getUsedCapacity()).append(" free space left in your backpack.\n");

        return storedItems.toString();
    }

    @Override
    public String getName() {
        return NAME;
    }
}
