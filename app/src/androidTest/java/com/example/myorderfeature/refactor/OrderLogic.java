// Scenario 4: REFACTOR - Logic for reordering a Past Order with Out-of-Stock Items
package com.example.myorderfeature;

import java.util.List;

public class OrderLogic {

    public static boolean hasOutOfStockItem(List<Item> items) {
        for (Item item : items) {
            if (!item.isAvailable())
                return true;
        }
        return false;
    }

    public static double calculateTotal(List<Item> items) {
        double totalprice = 0.0;
        for (Item item : items) {
            if (item.isAvailable()) {
                totalprice += item.getPrice();
            }
        }
        return totalprice;
    }
}
