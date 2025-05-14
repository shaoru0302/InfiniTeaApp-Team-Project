package com.example.infinitea;

/**
 * Enum class for different sizes of Milk Tea, each with its own base price.
 * Supports SMALL, MEDIUM, LARGE with corresponding prices.
 */
public enum Size {

    S("S", 5.25),
    M("M", 6.00),
    L("L", 6.75);

    private final String name;
    private final double basePrice;

    /**
     * Constructor for the Size enum.
     * @param name       Display name for the size (e.g., SMALL, MEDIUM, LARGE)
     * @param basePrice  Base price for this size
     */
    Size(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    /**
     * Get the display name for this size.
     * @return String name (e.g., "SMALL", "MEDIUM", "LARGE")
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Get the base price for this size.
     * @return double base price (e.g., 5.25 for SMALL)
     */
    public double getBasePrice() {
        return basePrice;
    }
}
