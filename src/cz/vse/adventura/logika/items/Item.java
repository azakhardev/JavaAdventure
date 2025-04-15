package cz.vse.adventura.logika.items;

public abstract class Item {
    private String name;
    private int volume;
    private int amount;
    private boolean lootable;

    public String getName() {
        return this.name;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getAmount() {
        return this.amount;
    }

    public boolean isLootable() {
        return this.lootable;
    }

    public abstract void useItem();
}
