//Scenario 2: Refactor - store sample drink lists for testing
package com.example.classicdrinkfeature;

import java.util.ArrayList;
import java.util.List;

public class DrinkRepository {

    public List<Drink> getClassicDrinks() {
        List<Drink> drinks = new ArrayList<>();

        drinks.add(new Drink(
                "Thai Bubble Milk Tea",
                "A creamy tea with bold Thai flavors with tapioca pearls",
                Size.MEDIUM,
                Sugar.HALF,
                Ice.NO_ICE,
                6.00
        ));

        drinks.add(new Drink(
                "Black Bubble Milk Tea",
                "Classic black tea with tapioca pearls",
                Size.LARGE,
                Sugar.FULL,
                Ice.LESS,
                6.75
        ));

        drinks.add(new Drink(
                "Rose Bubble Milk Tea",
                "Fragrant rose tea with tapioca pearls",
                Size.SMALL,
                Sugar.FULL,
                Ice.REGULAR,
                5.25
        ));

        return drinks;
    }
}
