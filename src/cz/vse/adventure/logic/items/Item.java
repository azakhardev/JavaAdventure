package cz.vse.adventure.logic.items;

import cz.vse.adventure.logic.commands.UseResult;
import cz.vse.adventure.logic.entities.Prop;

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

    public UseResult useItem(Prop prop) {
        return prop.applyItem(this);

    }
}
