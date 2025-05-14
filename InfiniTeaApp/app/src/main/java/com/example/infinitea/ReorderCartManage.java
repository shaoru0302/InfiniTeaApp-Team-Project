package com.example.infinitea;

import java.util.ArrayList;
import java.util.List;

public class ReorderCartManage {
    private static final List<MilkTea> cartItems = new ArrayList<>();

    public static void addToCart(MilkTea drink) {
        if (drink != null) {
            cartItems.add(drink);
        }
    }

    public static List<MilkTea> getCartItems() {
        return cartItems;
    }

    public static void clearCart() {
        cartItems.clear();
    }
}


