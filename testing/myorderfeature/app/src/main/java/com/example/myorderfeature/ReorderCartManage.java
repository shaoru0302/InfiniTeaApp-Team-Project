// for Scenario 3:  ReorderCartManager implementation for managing reordered items
package com.example.myorderfeature;

import java.util.ArrayList;
import java.util.List;
public class ReorderCartManage {
    private static final List<Order> cartItems = new ArrayList<>();

    public static void addToCart(Order order) {
        cartItems.add(order);
    }

    public static List<Order> getCartItems() {
        return new ArrayList<>(cartItems); // return a copy to avoid external modification
    }

    public static void clearCart() {
        cartItems.clear();
    }
}
