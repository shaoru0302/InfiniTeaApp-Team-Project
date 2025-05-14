/**
 * Tests for selecting and customizing a classic drink:
 * - Verifies default values on creation.
 * - Confirms changes like size, sugar, toppings work as expected.
 */

package com.example.infinitea;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassicDrinkSelectionLogicTest {

    MilkTea drink = new MilkTea(
            "Black Bubble milk tea",
            "Smooth and sweet classic",
            TeaBase.BLACK_TEA,
            true,
            Size.L,
            Sugar.HALF,
            Ice.HALF,
            new ArrayList<>(Arrays.asList(Topping.ALOE)),
            Size.L.getBasePrice()
    );

    @Test
    public void testCreation() {
        assertEquals("Black Bubble milk tea", drink.getName());
        assertEquals("Smooth and sweet classic", drink.getDescription());
        assertEquals(TeaBase.BLACK_TEA, drink.getTeaBase());
        assertEquals(Size.L, drink.getSize());
        assertEquals(Sugar.HALF, drink.getSugar());
        assertEquals(Ice.HALF, drink.getIce());
        assertEquals(1, drink.getToppings().size());
        assertEquals(Topping.ALOE, drink.getToppings().get(0));
    }

    @Test
    public void testChanges() {
        drink = new MilkTea(
                "Rose milk tea",
                "Floral and light",
                TeaBase.ROSE_TEA,
                true,
                Size.S,
                Sugar.NONE,
                Ice.REGULAR,
                new ArrayList<>(Arrays.asList(Topping.MANGO_JELLY, Topping.POPPING_BOBA)),
                Size.S.getBasePrice()
        );

        assertEquals("Rose milk tea", drink.getName());
        assertEquals("Floral and light", drink.getDescription());
        assertEquals(TeaBase.ROSE_TEA, drink.getTeaBase());
        assertEquals(Size.S, drink.getSize());
        assertEquals(Sugar.NONE, drink.getSugar());
        assertEquals(Ice.REGULAR, drink.getIce());
        assertEquals(2, drink.getToppings().size());
        assertEquals(Topping.MANGO_JELLY, drink.getToppings().get(0));
        assertEquals(Topping.POPPING_BOBA, drink.getToppings().get(1));
    }
}
