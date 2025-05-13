//Scenario 2: Test to see if the drink is valid
package com.example.classicdrink;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrderConfirmationLogicTest {

    public String addToCart(Drink drink){
        if (drink.getSugar() == null || drink.getIce() == null || drink.getSize() == null){
            return "Please fill all options";
        }
        return "Added to Cart";
    }

    @Test
    public void testSelection(){
        Drink testDrink = new Drink("Thai milk tea", "Tapioca", Sugar.Half, Ice.Less, Size.Large);

        String result = addToCart(testDrink);
        assertEquals("Added to Cart", result);
    }

    @Test
    public void failedSelection(){
        Drink testDrink = new Drink("Thai milk tea", "Tapioca", Sugar.Half, Ice.Less, null);

        String result = addToCart(testDrink);
        assertEquals("Please fill all options", result);
    }
}