package cz.vse.adventura.logika.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemsPool {
    public static List<Item> lootableItems = new ArrayList<Item>();
    public static List<Item> staticItems = new ArrayList<Item>();

    public static void fillLootablePool(Item... items){
        lootableItems.addAll(Arrays.asList(items));
    }
    public static void fillStaticPool(Item... items){
        lootableItems.addAll(Arrays.asList(items));
    }

}
