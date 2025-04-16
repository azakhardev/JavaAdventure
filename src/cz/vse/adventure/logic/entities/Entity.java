package cz.vse.adventure.logic.entities;

import cz.vse.adventure.logic.items.Item;

public abstract class Entity {
    public String name;

    public abstract String interact(Item item);

}
