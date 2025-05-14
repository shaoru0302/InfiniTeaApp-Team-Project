package com.example.infinitea;
/**
 * Enum class for holding a list of toppings with a specific String name.
 */

public enum Topping {
    /**Information of topping name for tea*/

    BUBBLES("BUBBLES"),
    CRYSTAL_BOBA("CRYSTAL BOBA"),
    POPPING_BOBA("POPPING BOBA"),
    MANGO_JELLY("MANGO JELLY"),
    GRASS_JELLY("GRASS JELLY"),
    PUDDING("PUDDING"),
    ALOE("ALOE");

    private final String name;

    /**
     * Size enum class constructor.
     * @param name String for topping's name.
     */

    Topping(String name){
        this.name = name;
    }

    /**
     * Return the topping information as a String.
     * @Return name String type of topping.
     */

    @Override
    public String toString(){
        return String.format("%S", this.name);
    }
}
