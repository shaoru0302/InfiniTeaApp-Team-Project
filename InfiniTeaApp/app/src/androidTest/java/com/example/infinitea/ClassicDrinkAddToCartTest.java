// classicdrink feature: Scenario: Test selecting drink options and adding to cart
package com.example.infinitea;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)

public class ClassicDrinkAddToCartTest {

    @Before
    public void setup() {
        ActivityScenario.launch(ChooseDrinkActivity.class);
    }

    @Test
    public void testAddClassicDrinkToCart() {
        onView(withId(R.id.drinkRecyclerView))
                .perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.spinnerSize)).perform(click());
        onView(withText("S")).perform(click());

        onView(withId(R.id.spinnerSugar)).perform(click());
        onView(withText("50%")).perform(click());

        onView(withId(R.id.spinnerIce)).perform(click());
        onView(withText("0%")).perform(click());

        onView(withId(R.id.btnAddToCart)).perform(click());

    }
}

