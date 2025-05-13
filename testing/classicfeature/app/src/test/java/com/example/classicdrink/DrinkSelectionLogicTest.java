//Scenario 1: Selecting drinks from menu
package com.example.classicdrink;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DrinkSelectionLogicTest {
    Drink drink = new Drink("Thai milk tea", "Tapioca", Sugar.Half, Ice.Less, Size.Large);

    @Test
    public void testCreation() {
        assertEquals("Thai milk tea", drink.getName());
        assertEquals("Tapioca", drink.getTopping());
        assertEquals(Sugar.Half, drink.getSugar());
        assertEquals(Ice.Less, drink.getIce());
        assertEquals (Size.Large, drink.getSize());
    }

    @Test
    public void testChanges(){
        drink.setName("Rose milk tea");
        drink.setTopping("Jelly");
        drink.setSugar(Sugar.None);
        drink.setIce(Ice.Regular);
        drink.setSize(Size.Small);

        assertEquals("Rose milk tea", drink.getName());
        assertEquals("Jelly", drink.getTopping());
        assertEquals(Sugar.None, drink.getSugar());
        assertEquals(Ice.Regular, drink.getIce());
        assertEquals (Size.Small, drink.getSize());
    }
}