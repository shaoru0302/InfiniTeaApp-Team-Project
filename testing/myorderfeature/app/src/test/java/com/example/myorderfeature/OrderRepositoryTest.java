// Scenario 1: unit tests for viewing past orders
package com.example.myorderfeature;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class OrderRepositoryTest {

    // Unit test #1: should return non-empty list if orders exist
    @Test
    public void testGetPastOrders_returnsNonEmpty() {
        OrderRepository repo = new OrderRepository();
        List<Order> orders = repo.getPastOrders();
        assertFalse(orders.isEmpty());
    }

    // Unit Test #2: Items should match correctly in the latest order details
    @Test
    public void testLastOrderContent() {
        OrderRepository repo = new OrderRepository();
        List<Order> orders = repo.getPastOrders();
        assertFalse(orders.isEmpty());

        Order lastOrder = orders.get(orders.size() - 1);
        List<Item> items = lastOrder.getItems();

        assertFalse(items.isEmpty());

        Item firstItemInLastOrder = items.get(1);

        assertEquals("Rose Tea", firstItemInLastOrder.getItemName());
        assertEquals(6.75, firstItemInLastOrder.getPrice(), 0.001);
        assertEquals("Large", firstItemInLastOrder.getSize());
    }
}
