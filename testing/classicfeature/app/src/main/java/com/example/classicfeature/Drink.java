package com.example.classicdrink;

public class Drink {
    private String name;
    private String topping;
    private Sugar sugar;
    private Ice ice;
    private Size size;

    public Drink(String name, String topping, Sugar sugar, Ice ice, Size size){
        this.name = name;
        this.topping = topping;
        this.sugar = sugar;
        this.ice = ice;
        this.size = size;
    }

    public String getName(){
        return name;
    }

    public String getTopping(){
        return topping;
    }

    public Sugar getSugar(){
        return sugar;
    }

    public Ice getIce(){
        return ice;
    }

    public Size getSize(){
        return size;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setTopping(String topping){
        this.topping = topping;
    }

    public void setSugar(Sugar sugar){
        this.sugar = sugar;
    }

    public void setIce(Ice ice){
        this.ice = ice;
    }

    public void setSize(Size size){
        this.size = size;
    }
}
