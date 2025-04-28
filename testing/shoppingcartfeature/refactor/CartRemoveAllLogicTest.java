package com.example.infiniteashoppingcart;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class CartRemoveAllLogicTest {
    private ArrayList<BubbleTea> bubbleTeaList;

    @Before
    public void setup() {
        bubbleTeaList = new ArrayList<>();
        bubbleTeaList.add(new BubbleTea("Thai milk tea", 6, 2,
                DrinkSize.LARGE, Topping.Bubble, IceLevel.Defualt, SugarLevel.Half));
        bubbleTeaList.add(new BubbleTea("Green tea", 6, 1,
                DrinkSize.MEDIUM, Topping.Pudding, IceLevel.None, SugarLevel.Half));
    }

    @Test
    public void testRemoveAllWhenCartAlreadyEmpty() {
        bubbleTeaList.clear();
        assertTrue("Cart is empty", bubbleTeaList.isEmpty());
        float total = calculateTotalPrice(bubbleTeaList);
        assertEquals(0.0f, total, 0.001);
        boolean removeButton = !bubbleTeaList.isEmpty();
        boolean orderButton = !bubbleTeaList.isEmpty();
        assertFalse("Remove button disabled", removeButton);
        assertFalse("Order button disabled", orderButton);
    }

    @Test
    public void TestRemoveAllItemAndPriceUpdate(){
        float beforeTotal = calculateTotalPrice(bubbleTeaList);
        assertTrue("Total is > 0", beforeTotal > 0);
        bubbleTeaList.clear();
        float afterTotal = calculateTotalPrice(bubbleTeaList);
        assertEquals(0.0f, afterTotal, 0.001);
        assertTrue("Cart is now empty.", bubbleTeaList.isEmpty());
        boolean removeButton = !bubbleTeaList.isEmpty();
        boolean orderButton = !bubbleTeaList.isEmpty();
        assertFalse("Remove button disabled", removeButton);
        assertFalse("Order button disabled", orderButton);
    }

    private float calculateTotalPrice(ArrayList<BubbleTea> list) {
        float total = 0f;
        for (BubbleTea item : list) {
            total += item.getTotalPrice();
        }
        return total;
    }
}
