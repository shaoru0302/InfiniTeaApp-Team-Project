package com.example.infinitea;
/**
 * Enum class for holding a list of tea bases with a specific String name.
 */

public enum TeaBase {
    /**Information of tea bases name for tea*/

    BLACK_TEA("BLACK TEA"),
    JASMINE_TEA("JASMINE TEA"),
    EARL_GREY_TEA("EARL GREY TEA"),
    ROSE_TEA("ROSE TEA"),
    OOLONG_TEA("OOLONG TEA"),
    MANGO_GREEN_TEA("MANGO GREEN TEA"),
    PASSION_FRUIT_GREEN_TEA("PASSION FRUIT GREEN TEA");

    private final String name;

    /**
     * Size enum class constructor.
     * @param name String for tea bases name.
     */

    TeaBase(String name){
        this.name = name;
    }

    /**
     * Return the tea bases information as a String.
     * @Return name String type of tea bases.
     */

    @Override
    public String toString(){
        return String.format("%S", this.name);
    }
}
