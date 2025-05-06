//Scenario 2: Select Multiple Toppings
package com.example.buildyourownfeature;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class ToppingsTest{

    private DrinkBuilder drinkB;

    @Before
    public void setUp(){
        drinkB = new DrinkBuilder();
    }

    @Test
    public void testAddSingleToppings(){
        drinkB.addTopping("Boba");
        Drink drink = drinkB.build();
        assertTrue(drink.getToppings().contains("Boba"));
    }

    @Test
    public void testAddMultipleToppings(){
        drinkB.addTopping("Boba");
        drinkB.addTopping("Pudding");

        Drink drink = drinkB.build();
        List<String> toppings = drink.getToppings();
        assertEquals(2, drink.getToppings().size());
        assertTrue(toppings.contains("Boba"));
        assertTrue(toppings.contains("Pudding"));
    }

}