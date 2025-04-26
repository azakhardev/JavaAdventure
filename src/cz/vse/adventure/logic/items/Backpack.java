package cz.vse.adventure.logic.items;

import cz.vse.adventure.logic.Room;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private int capacity;
    private List<Item> items = new ArrayList<>();

    public Backpack(int capacity) {
        this.capacity = capacity;
    }

    public String addCapacity(int capacity) {
        this.capacity += capacity;
        return "Now you have more capacity in your backpack: " + this.capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public Item getItemWithName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Metoda uloží předaný Item do batohu
     *
     * @param item věc, kterou chceme od batohu uložit
     * @param room místnost, ze které věc bereme
     */
    public Item storeItem(Item item, Room room) throws Exception {
        int itemVolume = item.getVolume();
        int freeSpace = this.capacity - this.getUsedCapacity();

        if ((itemVolume <= freeSpace) && item.isLootable()) {
            items.add(item);
            room.getItems().remove(item.getName());
            return item;
        }

        throw new Exception("You don't have enough space in your inventory for this item. You need at least " + itemVolume + " space.");
    }

    public Item storeItem(Item item) {
        int itemVolume = item.getVolume();
        int freeSpace = this.capacity - this.getUsedCapacity();

        if ((itemVolume <= freeSpace) && item.isLootable()) {
            items.add(item);
        }

        return item;
    }

    public String dropItem(Item item, Room room) {
        room.addItem(item);
        deleteItem(item);
        return "You've dropped " + item.getName() + " in " + room.getName() + " room.";
    }

    public boolean deleteItem(Item item) {
        items.remove(item);
        return items.contains(item);
    }

    public int getUsedCapacity() {
        int usedCapacity = 0;

        for (Item item : items) {
            usedCapacity += item.getVolume();
        }

        return usedCapacity;
    }

}
