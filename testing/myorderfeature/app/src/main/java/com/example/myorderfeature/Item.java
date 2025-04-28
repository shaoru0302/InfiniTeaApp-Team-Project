package com.example.myorderfeature;

import java.util.List;

public class Item {
    private final String itemName;
    private final boolean available;
    private final double itemPrice;
    private final String size;
    private final String sugar;
    private final String ice;
    private final List<String> toppings;


    public Item(String itemName, boolean available, String size, String sugar, String ice, List<String> toppings) {
        this.itemName = itemName;
        this.available = available;
        this.size = size;
        this.sugar = sugar;
        this.ice = ice;
        this.toppings = toppings;

        switch (size.toLowerCase()) {
            case "small":
                this.itemPrice = 5.25;
                break;
            case "medium":
                this.itemPrice = 6.00;
                break;
            case "large":
                this.itemPrice = 6.75;
                break;
            default:
                this.itemPrice = 5.25; // fallback
        }
    }


    public Item(String itemName, boolean available, double price,
                String size, String sugar, String ice, List<String> toppings) {
        this.itemName = itemName;
        this.available = available;
        this.itemPrice = price;
        this.size = size;
        this.sugar = sugar;
        this.ice = ice;
        this.toppings = toppings;
    }


    public String getItemName() { return itemName; }
    public boolean isAvailable() { return available; }
    public double getPrice() { return itemPrice; }
    public String getSize() { return size; }
    public String getSugar() { return sugar; }
    public String getIce() { return ice; }
    public List<String> getToppings() { return toppings; }
}
