package com.example.infiniteashoppingcart;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class CartUISupportLogicTest {
    private ArrayList<BubbleTea> bubbleTeaList;


    @Before
    public void SetUp() {
        bubbleTeaList = new ArrayList<>();
    }

    @Test
    public void TestEmptyCart() {
        float total = CalculateTotalPrice(bubbleTeaList);
        assertTrue("Cart should be empty", bubbleTeaList.isEmpty());
        assertEquals(0.0f, total, 0.001);
    }

    @Test
    public void TestCartWithItems() {
        bubbleTeaList.add(new BubbleTea("Thai milk tea", 6, 2,
                DrinkSize.LARGE, Topping.Bubble, IceLevel.Defualt, SugarLevel.Half));

        bubbleTeaList.add(new BubbleTea("Green tea", 6, 1,
                DrinkSize.MEDIUM, Topping.Pudding, IceLevel.None, SugarLevel.Half));

        bubbleTeaList.add(new BubbleTea("Black tea", 6, 3,
                DrinkSize.SMALL, Topping.RedBean, IceLevel.Half, SugarLevel.None));

        float expectedTotal = (6 * 2) + (6 ) + (6 * 3);
        float actualTotal = CalculateTotalPrice(bubbleTeaList);
        assertTrue("Cart should not be empty", !bubbleTeaList.isEmpty());

        assertEquals(expectedTotal, actualTotal, 0.001);
    }


    private float CalculateTotalPrice(ArrayList<BubbleTea> list) {
        float total = 0f;
        for (BubbleTea item : list) {
            total += item.getTotalPrice();
        }
        return total;
    }

}
