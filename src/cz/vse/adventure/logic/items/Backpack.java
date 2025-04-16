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
     * @param item věc, kterou chceme od batohu uložit
     * */
    public boolean storeItem(Item item) {
        int itemVolume = item.getVolume();

        if (itemVolume <= this.capacity - this.getUsedCapacity() && item.isLootable()) {
            items.add(item);
            return true;
        }

        return false;
    }

    public String dropItem(Item item, Room room) {
        //TODO: Add item to room, then delete it from backpack
        deleteItem(item);
        return "";
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
