package com.example.classicdrinkfeature;

public class Drink {
    private String name;
    private String description;
    private Size size;
    private Sugar sugar;
    private Ice ice;
    private double price;

    public Drink(String name, String description, Size size, Sugar sugar, Ice ice, double price) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.sugar = sugar;
        this.ice = ice;
        this.price = price;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Size getSize() { return size; }
    public Sugar getSugar() { return sugar; }
    public Ice getIce() { return ice; }
    public double getPrice() { return price; }
}
