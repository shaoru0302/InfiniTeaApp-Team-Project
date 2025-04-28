// Scenario 2 : for filtering order by order number

package com.example.myorderfeature;

import java.util.ArrayList;
import java.util.List;

public class OrderFilter {

    public static List<Order> filterByKeyword(List<Order> orders, String keyword) {
        List<Order> result = new ArrayList<>();
        for (Order o : orders) {
            if (o.getOrderNumber().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(o);
            }
        }
        return result;
    }
}
