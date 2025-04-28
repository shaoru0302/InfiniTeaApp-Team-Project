
package com.example.myorderfeature;

import java.util.List;

public class Order {
    private final String orderNumber;
    private final List<Item> items;
    private final String date; // e.g., "2025-04-27"

    public Order(String orderNumber, List<Item> items, String date) {
        this.orderNumber = orderNumber;
        this.items = items;
        this.date = date;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getDate() {
        return date;
    }

    public boolean hasOutOfStockItems() {
        for (Item item : items) {
            if (!item.isAvailable())
                return true;
        }
        return false;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
