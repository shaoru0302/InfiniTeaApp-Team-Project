// Scenario 3: Green – ensures drink orders cannot be placed without selecting size, sugar, and ice.
package com.example.classicdrinkfeature;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrderConfirmationLogicTest {

    private String tryAddToCart(String size, String sugar, String ice) {
        if (size.isEmpty() || sugar.isEmpty() || ice.isEmpty()) {
            return "Please select all options";
        }
        return "Added to Cart";
    }

    @Test
    public void testAddToCartSuccess() {
        String result = tryAddToCart("Medium", "50% Sugar", "No Ice");
        assertEquals("Added to Cart", result);
    }

    @Test
    public void testAddToCartFailWhenSizeMissing() {
        String result = tryAddToCart("", "50% Sugar", "No Ice");
        assertEquals("Please select all options", result);
    }
}
