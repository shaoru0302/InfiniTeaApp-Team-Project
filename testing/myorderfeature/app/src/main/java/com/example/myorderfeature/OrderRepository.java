// manually added new order items for checking past order list (in stock & out of stock)
package com.example.myorderfeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderRepository {

    public List<Order> getPastOrders() {
        List<Order> orders = new ArrayList<>();

        // Order 1: All in stock
        List<Item> order1Items = Arrays.asList(
                new Item("Thai Bubble Milk Tea", true, "Medium", "Normal", "Less Ice", Arrays.asList("Taro Ball", "Grass Jelly")),
                new Item("Jasmine Milk Tea", true, "Large", "Half Sugar", "Normal Ice", Arrays.asList("Pudding"))
        );
        orders.add(new Order("ORD001", order1Items, "2025-04-20"));

        // Order 2: One drink out of stock
        List<Item> order2Items = Arrays.asList(
                new Item("Rose Bubble Milk Tea", false, "Small", "No Sugar", "No Ice", Arrays.asList("Aloe Vera")),
                new Item("Oolong Milk Tea", true, "Medium", "Less Sugar", "Normal Ice", Arrays.asList())
        );
        orders.add(new Order("ORD002", order2Items, "2025-04-21"));

        // Order 3: All in stock, 3 drinks
        List<Item> order3Items = Arrays.asList(
                new Item("Black Tea", true, "Large", "Normal", "Normal Ice", Arrays.asList()),
                new Item("Mango Green Tea", true, "Medium", "Full Sugar", "Less Ice", Arrays.asList("Coconut Jelly")),
                new Item("Passion Fruit Green Tea", true, "Small", "Normal", "More Ice", Arrays.asList())
        );
        orders.add(new Order("ORD003", order3Items, "2025-04-23"));

        // Order 4: All out-of-stock
        List<Item> order4Items = Arrays.asList(
                new Item("Jasmine Bubble Milk Tea", false, "Medium", "Normal", "Normal Ice", Arrays.asList("Red Bean")),
                new Item("Rose Tea", false, "Large", "Less Sugar", "Less Ice", Arrays.asList("Pudding", "Boba"))
        );
        orders.add(new Order("ORD004", order4Items, "2025-04-24"));

        return orders;
    }
}
