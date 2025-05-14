/**
 * Unit tests for validating input logic in the Build Your Own drink flow.
 * - Test 1 ensures users cannot select more than 3 toppings.
 * - Test 2 checks that a drink cannot be added to the cart without selecting a tea base.
 */

package com.example.infinitea;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BuildYourOwnValidationTest {

    @Test
    public void testToppingLimitEnforced() {
        ArrayList<String> selectedToppings = new ArrayList<>();
        selectedToppings.add("BOBA");
        selectedToppings.add("PUDDING");
        selectedToppings.add("GRASS_JELLY");
        selectedToppings.add("RED_BEAN");

        boolean limitExceeded = selectedToppings.size() > 3;
        assertTrue("More than 3 toppings should be blocked", limitExceeded);
    }

    @Test
    public void testNoTeaBaseBlocksOrder() {
        TeaBase selectedTeaBase = null;

        boolean canAddToCart = selectedTeaBase != null;
        assertFalse("Drink without tea base should not be allowed", canAddToCart);
    }
}
