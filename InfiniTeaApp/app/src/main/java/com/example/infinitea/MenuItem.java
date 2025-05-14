package com.example.infinitea;

import java.util.ArrayList;

/**
 * Represents a drink item on the menu.
 * Each MenuItem includes a name, description, and a list of default toppings.
 * Used by the RecyclerView in ChooseDrinkActivity to show classic drink options.
 */

public class MenuItem {
    private String name;
    private String description;
    private ArrayList<Topping> defaultToppings;

    public MenuItem(String name, String description, ArrayList<Topping> defaultToppings) {
        this.name = name;
        this.description = description;
        this.defaultToppings = defaultToppings;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public ArrayList<Topping> getDefaultToppings() { return defaultToppings; }
}
