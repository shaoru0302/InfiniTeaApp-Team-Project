/**
 * Simple logic tests for classic drink validation:
 * - Makes sure all required options are selected before adding to cart.
 * - Checks that incomplete selections are caught properly.
 */

package com.example.infinitea;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;

public class ClassicDrinkValidationTest {

    // verify addToCart logic
    public String validateClassicDrink(MilkTea drink) {
        if (drink.getSize() == null || drink.getSugar() == null || drink.getIce() == null) {
            return "Please fill all options";
        }
        return "Added to Cart";
    }

    @Test
    public void testValidClassicDrinkSelection() {
        MilkTea drink = new MilkTea(
                "Jasmine Bubble Milk Tea",
                "Light and fragrant jasmine green tea with chewy tapioca pearls.",
                TeaBase.JASMINE_TEA,
                true,
                Size.L,
                Sugar.HALF,
                Ice.NONE,
                new ArrayList<>(),
                Size.L.getBasePrice()
        );

        String result = validateClassicDrink(drink);
        assertEquals("Added to Cart", result);
    }

    @Test
    public void testMissingOptionFails() {
        MilkTea drink = new MilkTea(
                "Black Bubble Milk Tea",
                "A rich black tea with chewy tapioca pearls.",
                TeaBase.BLACK_TEA,
                true,
                null, // Size is missing
                Sugar.NONE,
                Ice.REGULAR,
                new ArrayList<>(),
                0.0
        );

        String result = validateClassicDrink(drink);
        assertEquals("Please fill all options", result);
    }
}

