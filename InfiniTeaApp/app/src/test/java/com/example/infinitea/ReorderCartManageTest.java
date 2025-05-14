/**
 * Unit tests for managing the reorder cart logic.
 * - Test 1 checks that a reordered drink is added to the cart correctly.
 * - Test 2 confirms that the cart is properly cleared after calling clearCart().
 */

package com.example.infinitea;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ReorderCartManageTest {

    @Before
    public void setup() {
        ReorderCartManage.clearCart();
    }

    @Test
    public void testAddReorderedMilkTeaToCart() {

        MilkTea drink = new MilkTea(
                "Thai Bubble Milk Tea",
                "Classic Thai milk tea with bubbles",
                null,  // tea base: can be null for classic drinks
                true,
                Size.M,
                Sugar.REGULAR,
                Ice.REGULAR,
                new ArrayList<>(),
                Size.M.getBasePrice()
        );

        ReorderCartManage.addToCart(drink);

        List<MilkTea> cart = ReorderCartManage.getCartItems();
        assertEquals(1, cart.size());
        assertEquals("Thai Bubble Milk Tea", cart.get(0).getName());
    }


    @Test
    public void testClearReorderedCart() {
        MilkTea drink = new MilkTea(
                "Thai Bubble Milk Tea",
                "Classic Thai milk tea with bubbles",
                null,
                true,
                Size.S,
                Sugar.REGULAR,
                Ice.REGULAR,
                new ArrayList<>(),
                Size.S.getBasePrice()
        );

        ReorderCartManage.addToCart(drink);
        ReorderCartManage.clearCart();

        List<MilkTea> cart = ReorderCartManage.getCartItems();
        assertTrue(cart.isEmpty());
    }

}
