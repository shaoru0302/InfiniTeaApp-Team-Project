// Scenario 2: GREEN – Unit test for filtering orders by order number

package com.example.myorderfeature;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class OrderFilterTest {

    @Test
    public void testFilterReturnsMatch() {
        List<Order> orders = Arrays.asList(
                new Order("ORD001", "Rose Bubble Milk Tea", "$5.25"),
                new Order("ORD002", "Thai Bubble Milk Tea", "$5.25"),
                new Order("ORD003", "Black Bubble Milk Tea", "$5.25")
        );

        List<Order> result = OrderFilter.filterByKeyword(orders, "ORD002");

        assertEquals(1, result.size());
        assertEquals("ORD002", result.get(0).getOrderNumber());
    }

    @Test
    public void testFilterReturnsEmptyWhenNoMatch() {
        List<Order> orders = Arrays.asList(
                new Order("ORD001", "Rose Bubble Milk Tea", "$5.25"),
                new Order("ORD002", "Thai Bubble Milk Tea", "$5.25"),
                new Order("ORD003", "Black Bubble Milk Tea", "$5.25")
        );

        List<Order> result = OrderFilter.filterByKeyword(orders, "ORD999");

        assertTrue(result.isEmpty());
    }
}
