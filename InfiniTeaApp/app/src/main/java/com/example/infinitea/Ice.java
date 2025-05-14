package com.example.infinitea;

/**
 * Enum class for Ice level of tea.
 */

public enum Ice {
    /**Information of Ice level added*/
    REGULAR("100%"),
    HALF("50%"),
    NONE("0%");

    private final String name;

    /**
     * Ice level enum class constructor.
     * @param name String for Ice level name.
     */
    Ice(String name){
        this.name = name;
    }

    /**
     * Return the Ice level information as a String.
     * @Return name String type of Ice level.
     */

    @Override
    public String toString(){
        return String.format("%S", this.name);
    }
}
