package com.example.classicdrinkfeature;

public enum Sugar {
    ZERO("0% Sugar"),
    HALF("50% Sugar"),
    FULL("100% Sugar");

    private final String displayName;

    Sugar(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
