package com.example.buildyourown;

public class Drink {
    private final String iceLevel;
    private final String size;
    private final List<String> toppings;

    public Drink(String iceLevel, String size, List<String> toppings) {
        this.iceLevel = iceLevel;
        this.size = size;
        this.toppings = toppings;
    }

    public String getIceLevel() {
        return iceLevel;
    }

    public String getSize() {
        return size;
    }

    public List<String> getToppings() {
        return toppings;
    }
}
