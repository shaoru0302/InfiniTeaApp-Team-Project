// ShoppingCartActivity feature: Scenario: UI Test for access the Cart and view the content of items.
package com.example.infinitea;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CartDisplayItemUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testNavigateToCartAndSeeCartListView() {
        // click shopping cart button
        onView(withId(R.id.btn_shopping_cart)).perform(click());

        // check listView
        onView(withId(R.id.cartDrinkList)).check(matches(isDisplayed()));
    }
}
