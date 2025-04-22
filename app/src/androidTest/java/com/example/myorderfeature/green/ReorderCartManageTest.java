// Scenario 3: GREEN – Unit tests for reordering past orders (CartManager)
package com.example.myorderfeature;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class ReorderCartManageTest {

    @Before
    public void setup() {
        ReorderCartManage.clearCart();
    }

    @Test
    public void testAddReorderedItemToCart() {
        Order order = new Order("ORD001", "Rose Bubble Milk Tea", "$5.25");
        ReorderCartManage.addToCart(order);

        List<Order> cart = ReorderCartManage.getCartItems();
        assertEquals(1, cart.size());
        assertEquals("ORD001", cart.get(0).getOrderNumber());
    }

    @Test
    public void testClearReorderedCart() {
        ReorderCartManage.addToCart(new Order("ORD001", "Rose Bubble Milk Tea", "$5.25"));
        ReorderCartManage.addToCart(new Order("ORD002", "Thai Bubble Milk Tea", "$5.25"));

        ReorderCartManage.clearCart();
        List<Order> cart = ReorderCartManage.getCartItems();
        assertTrue(cart.isEmpty());
    }
}

