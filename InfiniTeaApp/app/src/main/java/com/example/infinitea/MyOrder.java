// manage order history
package com.example.infinitea;

import java.util.ArrayList;

/**
 * MyOrder class: manages all orders (order history for Infinitea app).
 */
public class MyOrder {

    /** List of all orders (order history) */
    private ArrayList<Order> orderList;

    /**
     * Constructor: initialize the order list.
     */
    public MyOrder() {
        orderList = new ArrayList<>();
    }

    /**
     * Get all orders (order history).
     */
    public ArrayList<Order> getOrderList() {
        return orderList;
    }


    /**
     * Add a new order to the history.
     * @param newOrder the order to add
     */
    public boolean addOrder(Order newOrder) {
        return orderList.add(newOrder);
    }

    /**
     * Remove an order from the history.
     * @param target the order to remove
     */
    public boolean removeOrder(Order target) {
        return orderList.remove(target);
    }
}
