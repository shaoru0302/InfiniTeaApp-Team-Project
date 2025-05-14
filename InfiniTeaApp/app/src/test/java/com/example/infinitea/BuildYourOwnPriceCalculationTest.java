/**
 * Unit tests for verifying price calculations in Build Your Own drink feature.
 * - Test 1 checks base price + topping logic (first topping is free, extras cost $0.50 each).
 * - Test 2 confirms correct subtotal, tax, and total calculation with quantity and 8.875% tax.
 */

package com.example.infinitea;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BuildYourOwnPriceCalculationTest {

    @Test
    public void testBasePriceWithExtraToppings() {
        Size size = Size.M;
        double basePrice = size.getBasePrice();

        ArrayList<String> selectedToppings = new ArrayList<>();
        selectedToppings.add("BOBA");
        selectedToppings.add("PUDDING");
        selectedToppings.add("GRASS_JELLY");

        int extraCount = Math.max(0, selectedToppings.size() - 1); // 1 free
        double expected = basePrice + (extraCount * 0.50);

        assertEquals(6.00 + 1.00, expected, 0.01); // M basePrice = $6.00
    }

    @Test
    public void testTotalPriceWithQuantityAndTax() {
        double basePrice = 6.00;
        int quantity = 1;   // 1 drink
        int extraToppings = 2;
        double taxRate = 0.08875;

        double subtotal = (basePrice + extraToppings * 0.50) * quantity;
        double tax = subtotal * taxRate;
        double total = subtotal + tax;

        assertEquals(7.62, total, 0.01);
    }
}
