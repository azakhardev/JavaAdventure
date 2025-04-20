package cz.vse.adventure.logic.entities;

import cz.vse.adventure.logic.items.Item;

import java.util.Objects;

public abstract class Entity {
    private String name;

    private String description;


    public Entity(String name, String descripton) {
        this.name = name;
        this.description = descripton;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract String interact();

    public abstract String applyItem(Item item);
}
