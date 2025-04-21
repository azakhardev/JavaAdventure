package cz.vse.adventure.logic.entities;

import cz.vse.adventure.logic.items.Item;

import java.util.Objects;
import java.util.function.Function;

public abstract class Entity {
    private String name;

    private String description;

    protected Function<Item, String> onUse;

    public Entity(String name, String descripton, Function<Item, String> onUse) {
        this.name = name;
        this.description = descripton;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setOnUse(Function<Item, String> onUse) {
        this.onUse = onUse;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract String interact();

    public abstract String applyItem(Item item);
}
