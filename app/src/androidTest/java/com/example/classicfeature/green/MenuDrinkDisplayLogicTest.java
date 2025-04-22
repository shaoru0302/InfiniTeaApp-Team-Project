// Scenario 1: Green - support the UI test that displays menu items on the order screen
package com.example.classicdrinkfeature;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class MenuDrinkDisplayLogicTest {

    @Test
    public void testClassicDrinkListIsNotEmpty() {
        DrinkRepository repo = new DrinkRepository();
        List<Drink> drinks = repo.getClassicDrinks();
        assertFalse("Drink list should not be empty", drinks.isEmpty());
    }

    @Test
    public void testDrinkHasExpectedName() {
        DrinkRepository repo = new DrinkRepository();
        List<Drink> drinks = repo.getClassicDrinks();

        Drink first = drinks.get(0);
        assertEquals("Thai Bubble Milk Tea", first.getName());
    }
}
