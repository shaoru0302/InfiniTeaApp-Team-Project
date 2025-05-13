//Scenario 3: Modifying drinks after selection
package com.example.classicdrink;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CartLogicTest {
    public List<Drink> classicDrinks() {
        List<Drink> drinks = new ArrayList<>();

        drinks.add(new Drink("Thai milk tea", "Tapioca", Sugar.Half, Ice.Less, Size.Large));
        drinks.add(new Drink("Rose milk tea", "Jelly", Sugar.None, Ice.Regular, Size.Small));
        drinks.add(new Drink("Matcha milk tea", "Mixed", Sugar.Regular, Ice.None, Size.Medium));
        return drinks;
    }

    @Test
    public void checkList() {
        List<Drink> drinks = classicDrinks();

        assertEquals("Thai milk tea", drinks.get(0).getName());
        assertEquals("Tapioca", drinks.get(0).getTopping());
        assertEquals(Sugar.Half, drinks.get(0).getSugar());
        assertEquals(Ice.Less, drinks.get(0).getIce());
        assertEquals(Size.Large, drinks.get(0).getSize());

        drinks.get(0).setSize(Size.Small);
        assertEquals(Size.Small, drinks.get(0).getSize());
    }

    @Test
    public void emptyList(){
        List <Drink> drinks = classicDrinks();
        drinks.remove(1);
        assertFalse(drinks.isEmpty(), "Drink list should not be empty");
        assertEquals(2, drinks.size(), "Drink list size should be 2");

        assertEquals("Thai milk tea", drinks.get(0).getName());
        assertEquals("Tapioca", drinks.get(0).getTopping());
        assertEquals(Sugar.Half, drinks.get(0).getSugar());
        assertEquals(Ice.Less, drinks.get(0).getIce());
        assertEquals(Size.Large, drinks.get(0).getSize());

        assertEquals("Matcha milk tea", drinks.get(1).getName());
        assertEquals("Mixed", drinks.get(1).getTopping());
        assertEquals(Sugar.Regular, drinks.get(1).getSugar());
        assertEquals(Ice.None, drinks.get(1).getIce());
        assertEquals(Size.Medium, drinks.get(1).getSize());

        drinks.clear();
        assertTrue(drinks.isEmpty(), "Drink list should be empty");
    }
}