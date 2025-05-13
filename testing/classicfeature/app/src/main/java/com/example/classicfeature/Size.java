package com.example.classicdrink;

public enum Size{
    Small("Small"),
    Medium("Medium"),
    Large("Large");

    private final String display;
    Size(String name){
        this.display = name;
    }

    public String getDisplay(){
        return display;
    }
}
