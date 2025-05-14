// Scenario: for filtering order by order number

package com.example.infinitea;

import java.util.ArrayList;
import java.util.List;

public class OrderFilter {

    public static List<Order> filterByKeyword(List<Order> orders, String keyword) {
        List<Order> result = new ArrayList<>();
        for (Order o : orders) {
            if (String.valueOf(o.getOrderNumber()).toLowerCase().contains(keyword.toLowerCase())) {
                result.add(o);
            }
        }
        return result;
    }
}
