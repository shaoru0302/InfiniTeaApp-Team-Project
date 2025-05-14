package com.example.infinitea;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Order class for Infinitea app, optimized version (saves MilkTea drinks).
 */
public class Order {

    // Unique order number
    private int orderNumber;

    // List of drinks (MilkTea objects) in this order
    private ArrayList<MilkTea> listOfDrinks;

    // Order date
    private String date;

    /**
     * Constructor for a new order.
     * @param previousOrderNumber Previous order number (auto-increment).
     */
    public Order(int previousOrderNumber) {
        this.orderNumber = previousOrderNumber + 1;
        this.listOfDrinks = new ArrayList<>();

        // Set current date and time as string
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        this.date = sdf.format(new Date());
    }

    // Getters
    public int getOrderNumber() {
        return orderNumber;
    }

    public ArrayList<MilkTea> getListOfDrinks() {
        return listOfDrinks;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    /**
     * Get list of drinks as display strings.
     */
    public List<String> getDisplayList() {
        List<String> displayList = new ArrayList<>();
        for (MilkTea drink : listOfDrinks) {
            displayList.add(drink.toDisplayString());  // MilkTea has toDisplayString()
        }
        return displayList;
    }

    /**
     * Calculate subtotal (sum of drink prices).
     */
    public String calculateSubtotal() {
        double subtotal = 0;
        for (MilkTea drink : listOfDrinks) {
            subtotal += drink.getTotalPrice();
        }
        return String.format("%.2f", subtotal);
    }

    /**
     * Calculate sales tax (8.875%).
     */
    public String calculateSalesTax() {
        double subtotal = 0;
        for (MilkTea drink : listOfDrinks) {
            subtotal += drink.getTotalPrice();
        }
        double tax = subtotal * 0.08875;
        return String.format("%.2f", tax);
    }

    /**
     * Calculate total (subtotal + tax).
     */
    public String calculateOrderTotal() {
        double subtotal = 0;
        for (MilkTea drink : listOfDrinks) {
            subtotal += drink.getTotalPrice();
        }
        double tax = subtotal * 0.08875;
        double total = subtotal + tax;
        return String.format("%.2f", total);
    }


    /**
     * Add a MilkTea drink to the order.
     */
    public boolean add(MilkTea drink) {
        if (drink != null) {
            listOfDrinks.add(drink);
            return true;
        }
        return false;
    }

    /**
     * Remove a MilkTea drink from the order.
     */
    public boolean remove(MilkTea drink) {
        return listOfDrinks.remove(drink);
    }
}
