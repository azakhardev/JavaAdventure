package cz.vse.adventure.logic.items;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private int capacity;
    private List<Item> items = new ArrayList<>();

    public Backpack(int capacity) {
        this.capacity = capacity;
    }

    public boolean storeItem(Item item) {
        int itemVolume = item.getVolume();

        if (itemVolume <= this.capacity - this.getUsedCapacity()) {
            items.add(item);
            return true;
        }

        return false;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getUsedCapacity() {
        int usedCapacity = 0;

        for (Item item : items) {
            usedCapacity += item.getAmount();
        }

        return usedCapacity;
    }
}
