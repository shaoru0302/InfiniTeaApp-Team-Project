package com.example.classicdrink;

public enum Sugar {
    Regular("100% Sugar"),
    Half("50% Sugar"),
    None("0% Sugar");

    private final String display;
    Sugar(String name){
        this.display = name;
    }

    public String getDisplay(){
        return display;
    }
}
