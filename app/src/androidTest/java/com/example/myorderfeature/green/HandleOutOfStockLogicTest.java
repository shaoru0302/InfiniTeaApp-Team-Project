// Scenario 4: GREEN – Unit tests for Reordering a Past Order with Out-of-Stock Items
package com.example.myorderfeature;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class HandleOutOfStockLogicTest {

        @Test
        public void testOrderContainsOutOfStockItem() {
            List<Item> items = Arrays.asList(
                    new Item("Rose bubble milk tea", false),
                    new Item("Thai Bubble Milk tea", true),
                    new Item("Black Bubble Milk Tea", true)
            );

            boolean result = OrderLogic.hasOutOfStockItem(items);
            assertTrue(result);
        }

        @Test
        public void testTotalPriceUpdatedCorrectly() {
            List<Item> items = Arrays.asList(
                    new Item("Thai Bubble Milk Tea", true, 5.25, "Small", "50% Sugar", "NO ICE" ),
                    new Item("Black Bubble Milk Tea", true, 5.25, "Small", "50% Sugar", "NO ICE")
            );

            double total = OrderLogic.calculateTotal(items);
            assertEquals(10.50, total, 0.001);
        }
    }
