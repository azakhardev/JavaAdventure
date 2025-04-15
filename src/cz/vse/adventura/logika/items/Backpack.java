package cz.vse.adventura.logika.items;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private int capacity;
    private List<Item> items = new ArrayList<>();

    public Backpack(int capacity) {
        this.capacity = capacity;
    }


}
