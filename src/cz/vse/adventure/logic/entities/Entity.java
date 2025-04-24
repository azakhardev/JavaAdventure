package cz.vse.adventure.logic.entities;

import cz.vse.adventure.logic.items.Item;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class Entity {
    private String name;

    private String description;

    protected Function<Item, String> onUse = (item) -> {
        return "You can't use " + item.getName() + " on this object!";
    };

    protected Supplier<String> onInteract = this::getDescription;


    public Entity(String name, String descripton, Function<Item, String> onUse, Supplier<String> onInteract) {
        this.name = name;
        this.description = descripton;
        this.onUse = onUse;
        this.onInteract = onInteract;
    }

    public Entity(String name, String descripton, Function<Item, String> onUse) {
        this.name = name;
        this.description = descripton;
        this.onUse = onUse;
    }

    public Entity(String name, String descripton, Supplier<String> onInteract) {
        this.name = name;
        this.description = descripton;
        this.onInteract = onInteract;
    }

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

    public void setOnUse(Function<Item, String> onUse) {
        this.onUse = onUse;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String interact() {
        return onInteract.get();
    }

    public String applyItem(Item item) {
        return onUse.apply(item);
    }
}
