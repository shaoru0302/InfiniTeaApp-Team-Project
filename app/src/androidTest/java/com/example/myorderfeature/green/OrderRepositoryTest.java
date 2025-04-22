// Scenario 1: GREEN - Unit test for viewing past order listing

package com.example.myorderfeature;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderRepositoryTest {

    // Unit test #1: access My orders page and view empty list
    @Test
    public void testGetPastOrders_returnsNonEmpty() {
        OrderRepository repo = new OrderRepository();
        List<Order> orders = repo.getPastOrders();
        assertFalse(orders.isEmpty());
    }

    // Unit test #2: display the first order if exists
    @Test
    public void testFirstOrderContent() {
        OrderRepository repo = new OrderRepository();
        Order first = repo.getPastOrders().get(0);
        assertEquals("Rose Bubble Milk Tea", first.getItemName());
        assertEquals("$5.25", first.getPrice());
    }
}
