// Scenario 4: REFACTOR - needed file for handling order items with available options

package com.example.myorderfeature;

public class Item {
    private final String itemName;
    private final boolean available;
    private final double itemPrice;

    private String size;
    private String sugarLevel;
    private String iceLevel;



    public Item(String name, boolean available) {
        this.itemName = name;
        this.available = available;
        this.itemPrice = 5.25; // default for testing
    }

    public Item(String name, boolean available, double price, String size, String sugarLevel, String iceLevel) {
        this.itemName = name;
        this.available = available;
        this.itemPrice = price;
        this.size = size;
        this.sugarLevel = sugarLevel;
        this.iceLevel = iceLevel;

    }

    public String getItemName() { return itemName; }

    public boolean isAvailable() { return available; }

    public double getPrice() { return itemPrice; }

    public String getSugarLevel() { return sugarLevel; }
    public String getIceLevel() { return iceLevel; }
    public String getSize() { return size; }

}
