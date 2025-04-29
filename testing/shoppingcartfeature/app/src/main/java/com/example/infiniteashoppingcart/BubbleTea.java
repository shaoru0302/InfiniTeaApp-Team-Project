package com.example.infiniteashoppingcart;

public class BubbleTea {
    private String name ;
    private int price ,quantity;

    private DrinkSize size;
    private Topping topping;

    private IceLevel iceLevel;
    private SugarLevel sugarLevel;

    public BubbleTea(String name, int price, int quantity ,DrinkSize size ,Topping topping ,IceLevel iceLevel,SugarLevel sugarLevel) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.size=size;
        this.topping=topping;
        this.iceLevel=iceLevel;
        this.sugarLevel=sugarLevel;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    public float getTotalPrice() {
        return price * quantity;
    }
    public DrinkSize getSize(){
        return size;
    }
    public Topping  getTopping(){
        return topping;
    }
    public IceLevel getIceLevel(){
        return iceLevel;
    }
    public SugarLevel getSugarLevel(){
        return  sugarLevel;
    }
}
