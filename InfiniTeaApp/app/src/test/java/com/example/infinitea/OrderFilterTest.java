/**
 * Unit tests for filtering order history using keyword search.
 * - Test 1 ensures the correct order is returned when the keyword matches an order number.
 * - Test 2 ensures no results are returned when there's no matching order number.
 */

package com.example.infinitea;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class OrderFilterTest {

    @Test
    public void testFilterReturnsMatch() {
        List<Order> orders = new ArrayList<>();

        Order order1 = new Order(0);
        MilkTea drink1 = new MilkTea(
                "Rose Bubble Milk Tea",
                "Floral rose tea",
                null,
                true,
                Size.S,
                Sugar.REGULAR,
                Ice.REGULAR,
                new ArrayList<>(),
                Size.S.getBasePrice()
        );
        order1.add(drink1);
        orders.add(order1);

        
        Order order2 = new Order(order1.getOrderNumber()); 
        MilkTea drink2 = new MilkTea(
                "Thai Bubble Milk Tea",
                "Classic Thai tea",
                null,
                true,
                Size.M,
                Sugar.REGULAR,
                Ice.NONE,
                new ArrayList<>(),
                Size.M.getBasePrice()
        );
        order2.add(drink2);
        orders.add(order2);

        List<Order> result = OrderFilter.filterByKeyword(orders, String.valueOf(order2.getOrderNumber()));

        assertEquals(1, result.size());
        assertEquals(order2.getOrderNumber(), result.get(0).getOrderNumber());
    }

    @Test
    public void testFilterReturnsEmptyWhenNoMatch() {
        List<Order> orders = new ArrayList<>();

        Order order1 = new Order(0);
        MilkTea drink1 = new MilkTea(
                "Rose Bubble Milk Tea",
                "Floral rose tea",
                null,
                true,
                Size.S,
                Sugar.REGULAR,
                Ice.REGULAR,
                new ArrayList<>(),
                Size.S.getBasePrice()
        );
        order1.add(drink1);
        orders.add(order1);

        Order order2 = new Order(order1.getOrderNumber());
        MilkTea drink2 = new MilkTea(
                "Thai Bubble Milk Tea",
                "Classic Thai tea",
                null,
                true,
                Size.M,
                Sugar.REGULAR,
                Ice.REGULAR,
                new ArrayList<>(),
                Size.M.getBasePrice()
        );
        order2.add(drink2);
        orders.add(order2);

        List<Order> result = OrderFilter.filterByKeyword(orders, "999");

        assertTrue(result.isEmpty());
    }

}
