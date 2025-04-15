package cz.vse.adventura.logika.items;

public abstract class Item {
    private String Name;
    private int Volume;
    private int Amount;
    private boolean Lootable;

    public String getName() {
        return Name;
    }

    public int getVolume() {
        return Volume;
    }

    public int getAmount() {
        return Amount;
    }

    public boolean isLootable() {
        return Lootable;
    }

    public abstract void useItem();
}
