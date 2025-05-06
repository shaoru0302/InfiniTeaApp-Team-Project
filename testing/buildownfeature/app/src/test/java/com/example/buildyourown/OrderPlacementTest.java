//Scenario 4: Place the Customized Orderpackage com.example.buildyourownfeature;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class OrderPlacementTest{

    private DrinkBuilder drinkB;

    @Before
    public void setUp(){
        drinkB = new DrinkBuilder();
    }

    @Test
    public void testDrinkContainsAllOptions(){
        drinkB.setIceLevel("Regular");
        drinkB.setSize("Medium");
        drinkB.addTopping("Boba");
        drinkB.addTopping("Jelly");

        Drink drink = drinkB.build();
        List<String> toppings = drink.getToppings();
        assertEquals(2, drink.getToppings().size());
        assertTrue(toppings.contains("Boba"));
        assertTrue(toppings.contains("Jelly"));
    }

}