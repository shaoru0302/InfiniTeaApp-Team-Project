package com.example.infinitea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuRepository {

    public static List<MenuItem> getClassicMilkTeaMenu() {
        List<MenuItem> menu = new ArrayList<>();

        menu.add(new MenuItem(
                "Black Bubble Milk Tea",
                "A rich black tea with chewy tapioca pearls.",
                new ArrayList<>(Collections.singletonList(Topping.BUBBLES))


        ));

        menu.add(new MenuItem(
                "Rose Bubble Milk Tea",
                "Floral rose tea blended with milk and chewy tapioca pearls.",
                new ArrayList<>(Collections.singletonList(Topping.BUBBLES))
        ));

        menu.add(new MenuItem(
                "Thai Bubble Milk Tea",
                "Creamy Thai tea with a bold flavor and chewy tapioca pearls.",
                new ArrayList<>(Collections.singletonList(Topping.BUBBLES))
        ));

        menu.add(new MenuItem(
                "Jasmine Bubble Milk Tea",
                "Light and fragrant jasmine green tea with chewy tapioca pearls.",
                new ArrayList<>(Collections.singletonList(Topping.BUBBLES))
        ));

        menu.add(new MenuItem(
                "Oolong Bubble Milk Tea",
                "Smooth oolong tea with a toasty note and chewy tapioca pearls.",
                new ArrayList<>(Collections.singletonList(Topping.BUBBLES))
        ));

        return menu;
    }

}
