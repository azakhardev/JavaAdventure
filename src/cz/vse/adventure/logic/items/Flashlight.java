package cz.vse.adventure.logic.items;

import cz.vse.adventure.logic.entities.Entity;

public class Flashlight extends Item {

    private boolean working;

    public Flashlight(String name, String description, int volume, String usableOn) {
        super(name, description, volume, usableOn);
    }

    @Override
    public String useItem(Entity entity) {

        if (entity.getName() == this.getName()) {
            if (this.working) {
                return "Now you can go trough " + entity.getName();
            } else {
                return "Your flashlight is missing batteries!";
            }
        }

        return "You can't use flashlight on" + entity.getName();
    }
}
