/**
 * Tests for basic cart behavior:
 * - Checks that an empty cart shows $0 total.
 * - Verifies that adding drinks updates the total price correctly with tax.
 */

package com.example.infinitea;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CartUISupportLogicTest {

    private Order testCart;

    @Before
    public void setUp() {
        testCart = new Order(0); // orderNumber starts from 1
    }

    @Test
    public void testEmptyCart() {
        assertTrue("Cart should be empty", testCart.getListOfDrinks().isEmpty());

        float total = Float.parseFloat(testCart.calculateOrderTotal());
        assertEquals(0.0f, total, 0.001);
    }

    @Test
    public void testCartWithItems() {
        // add 2 drinks
        testCart.add(new MilkTea(
                "Rose Bubble Milk Tea",
                "Sweet Thai-style tea",
                TeaBase.ROSE_TEA,
                true,
                Size.L,
                Sugar.REGULAR,
                Ice.REGULAR,
                new ArrayList<>(),
                6.75
        ));

        testCart.add(new MilkTea(
                "Green Tea",
                "Light green milk tea",
                TeaBase.JASMINE_TEA,
                true,
                Size.M,
                Sugar.HALF,
                Ice.NONE,
                new ArrayList<>(),
                6.00
        ));

        assertFalse("Cart should not be empty", testCart.getListOfDrinks().isEmpty());

        // Calculate total with tax
        double subtotal = 6.75 + 6.00;
        double tax = subtotal * 0.08875;
        double expectedTotal = subtotal + tax;

        float actualTotal = Float.parseFloat(testCart.calculateOrderTotal());
        assertEquals((float) expectedTotal, actualTotal, 0.01);
    }
}

