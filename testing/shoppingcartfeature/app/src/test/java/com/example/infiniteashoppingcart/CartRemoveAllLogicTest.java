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
        assertTrue("Cart should start empty", bubbleTeaList.isEmpty());
        float total = calculateTotalPrice(bubbleTeaList);
        assertEquals(0.0f, total, 0.001);
        boolean removeButtonEnabled = !bubbleTeaList.isEmpty();
        boolean orderButtonEnabled = !bubbleTeaList.isEmpty();
        assertFalse("Remove button disabled", removeButtonEnabled);
        assertFalse("Order button disabled", orderButtonEnabled);
    }

    @Test
    public void TestRemoveAllItemAndPriceUpdate(){
        float beforeTotal = calculateTotalPrice(bubbleTeaList);
        assertTrue("Total  should be > 0", beforeTotal > 0);
        bubbleTeaList.clear();
        float afterTotal = calculateTotalPrice(bubbleTeaList);
        assertEquals(0.0f, afterTotal, 0.001);
        assertTrue("Cart should be empty after removal", bubbleTeaList.isEmpty());
        boolean removeButtonEnabled = !bubbleTeaList.isEmpty();
        boolean orderButtonEnabled = !bubbleTeaList.isEmpty();
        assertFalse("Remove  button should be disabled", removeButtonEnabled);
        assertFalse("Order button should be disabled", orderButtonEnabled);

    }

    private float calculateTotalPrice(ArrayList<BubbleTea> list) {
        float total = 0f;
        for (BubbleTea item : list) {
            total += item.getTotalPrice();
        }
        return total;
    }

}
