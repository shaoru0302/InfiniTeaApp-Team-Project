//Scenario 2: Green - for drink selection logic
package com.example.classicdrinkfeature;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class OrderClassicDrinkLogicTest {

    @Test
    public void testThaiMilkTeaIsAvailable() {
        DrinkRepository repo = new DrinkRepository();
        List<Drink> drinks = repo.getClassicDrinks();
        boolean found = drinks.stream().anyMatch(d -> d.getName().equals("Thai Bubble Milk Tea"));
        assertTrue("Thai Bubble Milk Tea should exist in drink list", found);
    }

    @Test
    public void testCreateDrinkWithOptions() {
        Drink drink = new Drink(
                "Thai Bubble Milk Tea",
                "A creamy tea with bold Thai flavors",
                Size.MEDIUM,
                Sugar.HALF,
                Ice.NO_ICE,
                6.00
        );

        assertEquals("Thai Bubble Milk Tea", drink.getName());
        assertEquals(Size.MEDIUM, drink.getSize());
        assertEquals(Sugar.HALF, drink.getSugar());
        assertEquals(Ice.NO_ICE, drink.getIce());
    }
}
