package cz.vse.adventure.logic.entities;

import cz.vse.adventure.logic.items.Item;

import java.util.Objects;

public abstract class Entity {
    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract String interact();

    public abstract String applyItem(Item item);
}
