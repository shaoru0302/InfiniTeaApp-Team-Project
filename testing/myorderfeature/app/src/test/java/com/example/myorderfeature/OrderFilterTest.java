// Scenario 2: unit tests for filtering the past orders
package com.example.myorderfeature;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class OrderFilterTest {
    // display all items in the order
    @Test
    public void testFilterReturnsMatch() {
        List<Order> orders = Arrays.asList(
                new Order("ORD001", Collections.singletonList(
                        new Item("Rose Bubble Milk Tea", false, "Small", "Normal", "Normal", Collections.emptyList())
                ), "2025-04-20"),
                new Order("ORD002", Collections.singletonList(
                        new Item("Thai Bubble Milk Tea", true, "Medium", "Normal", "Less Ice", Collections.emptyList())
                ), "2025-04-21"),
                new Order("ORD003", Collections.singletonList(
                        new Item("Black Bubble Milk Tea", true, "Large", "Full", "Normal", Collections.emptyList())
                ), "2025-04-22")
        );

        List<Order> result = OrderFilter.filterByKeyword(orders, "ORD002");

        assertEquals(1, result.size());
        assertEquals("ORD002", result.get(0).getOrderNumber());
    }

    // return nothing when there's nothing match in the order
    @Test
    public void testFilterReturnsEmptyWhenNoMatch() {
        List<Order> orders = Arrays.asList(
                new Order("ORD001", Collections.singletonList(
                        new Item("Rose Bubble Milk Tea", false, "Small", "Normal", "Normal", Collections.emptyList())
                ), "2025-04-20"),
                new Order("ORD002", Collections.singletonList(
                        new Item("Thai Bubble Milk Tea", true, "Medium", "Normal", "Less Ice", Collections.emptyList())
                ), "2025-04-21"),
                new Order("ORD003", Collections.singletonList(
                        new Item("Black Bubble Milk Tea", true, "Large", "Full", "Normal", Collections.emptyList())
                ), "2025-04-22")
        );

        List<Order> result = OrderFilter.filterByKeyword(orders, "ORD999");

        assertTrue(result.isEmpty());
    }
}
