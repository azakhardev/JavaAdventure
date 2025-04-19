package cz.vse.adventure.logic.items;

import cz.vse.adventure.logic.entities.Entity;

public abstract class Item {
    private String name;
    private String description;
    private String usableOn;
    private int volume;
    private boolean lootable;

    public Item(String name, String description, int volume, String usableOn) {
        this.name = name;
        this.description = description;
        this.volume = volume;
        this.usableOn = usableOn;
        this.lootable = volume < 0;
    }

    public String getName() {
        return this.name;
    }

    public int getVolume() {
        return this.volume;
    }

    public String getUsableOn() {
        return this.usableOn;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isLootable() {
        return this.lootable;
    }

    public abstract String useItem(Entity entity);
}
