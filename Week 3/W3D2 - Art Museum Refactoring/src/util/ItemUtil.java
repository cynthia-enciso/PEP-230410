package util;

import java.util.ArrayList;

import models.Item;

public class ItemUtil {
       // violate single responsibility here:
       public static void displayItems(ArrayList<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + 1 + ") " + items.get(i).getName());
        }
        System.out.println(items.size() + 1 + ") quit");
    }
}
