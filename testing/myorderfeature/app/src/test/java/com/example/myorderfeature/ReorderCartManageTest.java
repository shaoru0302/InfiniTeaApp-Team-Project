// Scenario 3: unit tests for adding past order items into cart
package com.example.myorderfeature;

import org.junit.Before;
import org.junit.Test;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ReorderCartManageTest {

    @Before
    public void setup() {
        ReorderCartManage.clearCart();
    }

    @Test
    public void testAddReorderedItemToCart() {
        Item item = new Item("Thai Bubble Milk Tea", true, "Medium", "Normal", "Normal", Collections.emptyList());
        Order order = new Order("ORD002", Collections.singletonList(item), "2025-04-24");

        ReorderCartManage.addToCart(order);

        List<Order> cart = ReorderCartManage.getCartItems();
        assertEquals(1, cart.size());
        assertEquals("ORD002", cart.get(0).getOrderNumber());
    }

    @Test
    public void testClearReorderedCart() {
        Item item = new Item("Thai Bubble Milk Tea", true, "Medium", "Normal", "Normal", Collections.emptyList());
        Order order = new Order("ORD002", Collections.singletonList(item), "2025-04-24");

        ReorderCartManage.addToCart(order);
        ReorderCartManage.clearCart();

        List<Order> cart = ReorderCartManage.getCartItems();
        assertTrue(cart.isEmpty());
    }
}
