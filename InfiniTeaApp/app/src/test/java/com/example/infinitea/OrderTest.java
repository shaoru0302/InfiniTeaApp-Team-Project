/**
 * Unit tests for the Order class functionality.
 * - Test 1 verifies that a drink can be successfully added to an order.
 * - Test 2 checks that subtotal, tax, and total price calculations are accurate.
 */

package com.example.infinitea;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void testOrderAddDrink() {

        MilkTea drink = new MilkTea(
                "Thai Bubble Milk Tea",
                "Classic Thai milk tea with bubbles",
                null,  // tea base
                true,
                Size.L,
                Sugar.REGULAR,
                Ice.REGULAR,
                new ArrayList<>(),
                Size.L.getBasePrice()
        );


        Order order = new Order(0);
        boolean added = order.add(drink);


        assertTrue(added);
        assertEquals(1, order.getListOfDrinks().size());
        assertEquals("Thai Bubble Milk Tea", order.getListOfDrinks().get(0).getName());
    }

    @Test
    public void testOrderCalculations() {
        MilkTea drink = new MilkTea(
                "Thai Bubble Milk Tea",
                "Classic Thai milk tea with bubbles",
                null,
                true,
                Size.L,
                Sugar.REGULAR,
                Ice.REGULAR,
                new ArrayList<>(),
                6.75
        );

        Order order = new Order(0);
        order.add(drink);


        double subtotal = Double.parseDouble(order.calculateSubtotal());
        double tax = Double.parseDouble(order.calculateSalesTax());
        double total = Double.parseDouble(order.calculateOrderTotal());

        assertEquals(6.75, subtotal, 0.001);
        assertEquals(6.75 * 0.08875, tax, 0.001);
        assertEquals(6.75 + (6.75 * 0.08875), total, 0.001);
    }
}
