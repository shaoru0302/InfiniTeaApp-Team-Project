package com.example.buildyourown;

import java.util.ArrayList;
import java.util.List;

public class DrinkBuilder {
    private String iceLevel;
    private String size;
    private final List<String> toppings = new ArrayList<>();

    public void setIceLevel(String iceLevel) {
        this.iceLevel = iceLevel;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public Drink build() {
        return new Drink(iceLevel, size, new ArrayList<>(toppings));
    }
}
