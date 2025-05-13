package com.example.classicdrink;

public enum Ice {
    Regular("Regular Ice"),
    Less("Less Ice"),
    None("No Ice");

    private final String display;
    Ice(String name){
        this.display = name;
    }

    public String getDisplay(){
        return display;
    }
}
