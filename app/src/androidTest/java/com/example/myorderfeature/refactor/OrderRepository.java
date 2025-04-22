// Scenario 2 : GREEN Test needed filter file
package com.example.myorderfeature;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    public List<Order> getPastOrders() {
        List<Order> list = new ArrayList<>();
        list.add(new Order("ORD001", "Rose Bubble Milk Tea", "$5.25"));
        list.add(new Order("ORD002", "Thai Bubble Milk Tea", "$5.25"));
        list.add(new Order("ORD003", "Black Bubble Milk Tea", "$5.25"));
        return list;
    }
}
