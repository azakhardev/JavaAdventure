package cz.vse.adventure.logic.items;

import cz.vse.adventure.logic.entities.Entity;

public class Item {
    private String name;
    private String description;
    private int volume;
    private boolean lootable;

    public Item(String name, String description, int volume) {
        this.name = name;
        this.description = description;
        this.volume = volume;
        this.lootable = volume >= 0;
    }

    public String getName() {
        return this.name;
    }

    public int getVolume() {
        return this.volume;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isLootable() {
        return this.lootable;
    }

    public String useItem(Entity entity) {
        return entity.applyItem(this);

    }
}
