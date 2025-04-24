package cz.vse.adventure.logic.entities;

import cz.vse.adventure.logic.items.Item;

import java.util.function.Function;
import java.util.function.Supplier;

public class Prop {
    private String name;

    private String description;

    protected Function<Item, String> onUse = (item) -> {
        return "You can't use " + item.getName() + " on this object!";
    };

    protected Supplier<String> onInteract = this::getDescription;


    public Prop(String name, String descripton, Function<Item, String> onUse, Supplier<String> onInteract) {
        this.name = name;
        this.description = descripton;
        this.onUse = onUse;
        this.onInteract = onInteract;
    }

    public Prop(String name, String descripton, Function<Item, String> onUse) {
        this.name = name;
        this.description = descripton;
        this.onUse = onUse;
    }

    public Prop(String name, String descripton, Supplier<String> onInteract) {
        this.name = name;
        this.description = descripton;
        this.onInteract = onInteract;
    }

    public Prop(String name, String descripton) {
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

    public void setOnUse(Function<Item, String> onUse) {
        this.onUse = onUse;
    }

    public void setOnInteract(Supplier<String> onInteract) {
        this.onInteract = onInteract;
    }

    public String interact() {
        return onInteract.get();
    }

    public String applyItem(Item item) {
        return onUse.apply(item);
    }
}
