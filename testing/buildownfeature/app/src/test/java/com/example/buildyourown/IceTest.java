//Scenario 3: Adjust Ice Level
package com.example.buildyourownfeature;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class IceTest{

    private DrinkBuilder drinkB;

    @Before
    public void setUp(){
        drinkB = new DrinkBuilder();
    }

    @Test
    public void testIceLevel_50Percent(){
        drinkB.setIceLevel("50%");
        Drink drink = drinkB.build();
        assertEquals("50%", drink.getIceLevel());
    }

    @Test
    public void testIceLevel_None(){
        drinkB.setIceLevel("None");
        Drink drink = drinkB.build();
        assertEquals("None", drink.getIceLevel());
    }

}