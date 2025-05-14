package com.example.infinitea;
/**
 * Enum class for Sugar level of tea.
 */

public enum Sugar {
    /**Information of Sugar level added*/
    REGULAR("100%"),
    HALF("50%"),
    NONE("0%");

    private final String name;

    /**
     * Sugar level enum class constructor.
     * @param name String for Sugar level name.
     */
    Sugar(String name){
        this.name = name;
    }

    /**
     * Return the Sugar level information as a String.
     * @Return name String type of Sugar level.
     */

    @Override
    public String toString(){
        return name;
    }
}

