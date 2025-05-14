package com.example.infinitea;

import java.util.ArrayList;
import java.util.List;

/**
 * MilkTea class that represents any type of bubble milk tea.
 * Flexible: supports name, description, tea base, size, sugar, ice, toppings, and pricing logic.
 * Pricing rules:
 * - 1 free topping
 * - Max 3 toppings
 * - Extra toppings: $0.50 each
 * Example: new MilkTea("Oolong Milk Tea", "Smooth and classic oolong base", TeaBase.OOLONG, true, Size.M, Sugar.NORMAL, Ice.NORMAL, toppings, 6.00);
 */
public class MilkTea {

    // Basic attributes
    private String name;             // e.g., "Oolong Bubble Milk Tea"
    private String description;      // e.g., "Smooth and fragrant oolong tea with milk"
    private TeaBase teaBase;         // e.g., TeaBase.OOLONG
    private boolean available;       // true = available, false = out of stock
    private Size size;
    private Sugar sugar;
    private Ice ice;
    private ArrayList<Topping> toppings;  // List of toppings (0~7)
    private double basePrice;        // Base price for the size

    // Pricing rules
    private static final int FREE_TOPPING_LIMIT = 1;
    private static final double EXTRA_TOPPING_PRICE = 0.50;

    /**
     * Full constructor for MilkTea.
     * @param name        Name of the drink (e.g., "Oolong Milk Tea")
     * @param description Short description of the drink
     * @param available   Availability (true/false)
     * @param size        Size enum
     * @param sugar       Sugar enum
     * @param ice         Ice enum
     * @param toppings    List of toppings (can be null)
     */
    public MilkTea(String name, String description, TeaBase teaBase, boolean available,
                   Size size, Sugar sugar, Ice ice, ArrayList<Topping> toppings, double basePrice) {
        this.name = name;
        this.description = description;
        this.available = available;
        this.teaBase = teaBase;
        this.size = size;
        this.sugar = sugar;
        this.ice = ice;
        this.toppings = (toppings != null) ? toppings : new ArrayList<>();
        this.basePrice = basePrice;
    }


    /**
     * Calculate total price: base price + extra topping charge.
     * @return total price
     */
    public double getTotalPrice() {
        double total = basePrice;
        int extraToppings = Math.max(0, toppings.size() - FREE_TOPPING_LIMIT);
        total += extraToppings * EXTRA_TOPPING_PRICE;
        return total;
    }

    /**
     * Display string for UI (e.g., shopping cart or history).
     * @return formatted string with drink details
     */
    public String toDisplayString() {
        List<String> toppingNames = new ArrayList<>();
        for (Topping t : toppings) {
            toppingNames.add(t.toString());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");

        // if there's no teaBase,then skip line
        if (teaBase != null) {
            sb.append("  • Tea Base: ").append(teaBase).append("\n");
        }

        sb.append("  • Size: ").append(size).append("\n");
        sb.append("  • Sugar: ").append(sugar).append("\n");
        sb.append("  • Ice: ").append(ice).append("\n");

        if (!toppingNames.isEmpty()) {
            sb.append("  • Toppings: ").append(String.join(", ", toppingNames)).append("\n");
        } else {
            sb.append("  • Toppings: None\n");
        }

        sb.append("  • Price: $").append(String.format("%.2f", getTotalPrice()));

        return sb.toString();
    }


    // Getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isAvailable() { return available; }
    public TeaBase getTeaBase() {   return teaBase; }

    public Size getSize() { return size; }
    public Sugar getSugar() { return sugar; }
    public Ice getIce() { return ice; }
    public ArrayList<Topping> getToppings() { return toppings; }

    @Override
    public String toString() {
        return toDisplayString();
    }
}
