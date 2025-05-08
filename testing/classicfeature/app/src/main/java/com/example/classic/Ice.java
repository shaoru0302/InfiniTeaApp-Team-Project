package com.example.classicdrinkfeature;

public enum Ice {
    NO_ICE("No Ice"),
    LESS("Less Ice"),
    REGULAR("Regular Ice");

    private final String displayName;

    Ice(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
