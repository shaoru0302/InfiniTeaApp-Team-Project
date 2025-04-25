package com.example.infiniteashoppingcart;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class CartRemoveOneItemLogicTest {
    private ArrayList<BubbleTea> bubbleTeaList;
    ArrayList<BubbleTea> bubbleTeaListBackup;

    @Before
    public void setup() {
        bubbleTeaList = new ArrayList<>();
        bubbleTeaList.add(new BubbleTea("Thai milk tea", 6, 2,
                DrinkSize.LARGE, Topping.Bubble, IceLevel.Defualt, SugarLevel.Half));
        bubbleTeaList.add(new BubbleTea("Green tea", 6, 1,
                DrinkSize.MEDIUM, Topping.Pudding, IceLevel.None, SugarLevel.Half));

        bubbleTeaListBackup=new ArrayList<>();
        for (BubbleTea bubbleTea:bubbleTeaList){
            bubbleTeaListBackup .add(bubbleTea);
        }
    }

    @Test
    public void testCancelRemovalNoChange() {
        // no .remove call  assume have this function ;
        assertEquals(bubbleTeaListBackup.size(), bubbleTeaList.size());
        assertEquals(bubbleTeaListBackup.get(0).getName(), bubbleTeaList.get(0).getName());
        assertEquals(bubbleTeaListBackup.get(1).getName(), bubbleTeaList.get(1).getName());
    }

    @Test
    public void testRemoveItemAfterConfirm() {
        assertEquals(2, bubbleTeaList.size());
        bubbleTeaList.remove(1);
        assertEquals(1, bubbleTeaList.size());
        assertEquals("Thai milk tea", bubbleTeaList.get(0).getName());
        float total = calculateTotalPrice(bubbleTeaList);
        assertEquals(12,total,0.01);
    }

    private float calculateTotalPrice(ArrayList<BubbleTea> list) {
        float total = 0f;
        for (BubbleTea item : list) {
            total += item.getTotalPrice();
        }
        return total;
    }
}
