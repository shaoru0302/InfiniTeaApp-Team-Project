// Scenario 3: REFACTOR – data model class used to represent individual order
package com.example.myorderfeature;

public class Order {
    private String orderNumber;
    private String itemName;
    private String price;

    public Order(String orderNumber, String itemName, String price) {
        this.orderNumber = orderNumber;
        this.itemName = itemName;
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPrice() {
        return price;
    }
}

