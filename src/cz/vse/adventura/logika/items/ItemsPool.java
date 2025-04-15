package cz.vse.adventura.logika.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemsPool {
    public static List<Item> Items = new ArrayList<Item>();

    public static void FillPool(Item... items){
        Items.addAll(Arrays.asList(items));
    }

}
