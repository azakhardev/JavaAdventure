package cz.vse.adventure.logic.items;

import cz.vse.adventure.logic.entities.Entity;

public class Flashlight extends Item {

    private boolean working;

    public Flashlight(String name, String description, int volume) {
        super(name, description, volume);
    }

    @Override
    public String useItem(Entity entity) {
        return "You can't use flashlight on" + entity.getName();
    }
}
