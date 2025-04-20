package cz.vse.adventure.logic.entities;

import cz.vse.adventure.logic.items.Item;

public class Prop extends Entity {

    private String type;

    public Prop(String name, String descripton, String type) {
        super(name, descripton);
        this.type = type;
    }

    @Override
    public String interact() {
        return "";
    }

    @Override
    public String applyItem(Item item) {
        return "";
    }
}
