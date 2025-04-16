package cz.vse.adventure.logic.entities;

import cz.vse.adventure.logic.items.Item;

import java.util.Objects;

public abstract class Entity {
    public String name;

    public String description;

    public abstract String interact(Item item);
}
