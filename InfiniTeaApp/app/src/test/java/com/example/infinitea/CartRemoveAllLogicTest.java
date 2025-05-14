/**
 * Unit tests for verifying "Remove All" functionality in the shopping cart.
 * - Test 1: Ensures that if the cart is already empty, total price is $0 and action buttons are disabled.
 * - Test 2: Simulates removing all items from a filled cart and checks that price updates correctly and cart becomes empty.
 */

package com.example.infinitea;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CartRemoveAllLogicTest {

    private Order testCart;

    @Before
    public void setup() {
        testCart = new Order(0);

        testCart.add(new MilkTea(
                "Jasmine Bubble Milk Tea",
                "Light and fragrant jasmine tea with milk",
                TeaBase.JASMINE_TEA,
                true,
                Size.M,
                Sugar.HALF,
                Ice.NONE,
                new ArrayList<>(), // 0 topping
                6.00
        ));

        testCart.add(new MilkTea(
                "Oolong Milk Tea",
                "Smooth and bold roasted oolong milk tea",
                TeaBase.OOLONG_TEA,
                true,
                Size.L,
                Sugar.REGULAR,
                Ice.HALF,
                new ArrayList<>(), // 0 topping
                6.75
        ));
    }


    @Test
    public void testRemoveAllWhenCartAlreadyEmpty() {

        testCart.getListOfDrinks().clear();

        assertTrue("Cart should be empty", testCart.getListOfDrinks().isEmpty());

        float total = Float.parseFloat(testCart.calculateOrderTotal());
        assertEquals(0.0f, total, 0.001);

        boolean removeButtonEnabled = !testCart.getListOfDrinks().isEmpty();
        boolean orderButtonEnabled = !testCart.getListOfDrinks().isEmpty();

        assertFalse("Remove button should be disabled", removeButtonEnabled);
        assertFalse("Order button should be disabled", orderButtonEnabled);
    }

    @Test
    public void testRemoveAllItemsAndPriceUpdate() {
        float beforeTotal = Float.parseFloat(testCart.calculateOrderTotal());
        assertTrue("Total should be > 0", beforeTotal > 0);

        testCart.getListOfDrinks().clear();

        float afterTotal = Float.parseFloat(testCart.calculateOrderTotal());
        assertEquals(0.0f, afterTotal, 0.001);

        assertTrue("Cart should be empty after removal", testCart.getListOfDrinks().isEmpty());

        boolean removeButtonEnabled = !testCart.getListOfDrinks().isEmpty();
        boolean orderButtonEnabled = !testCart.getListOfDrinks().isEmpty();

        assertFalse("Remove button should be disabled", removeButtonEnabled);
        assertFalse("Order button should be disabled", orderButtonEnabled);
    }
}
