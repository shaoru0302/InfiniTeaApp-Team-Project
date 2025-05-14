// ShoppingCartActivity feature: Scenario: Tests placing an order
// and displaying order details in ShoppingCartActivity.
package com.example.infinitea;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.action.ViewActions.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CartOrderFlowAndUIDisplayTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testOrderFlowShowsReceiptDetails() {
        // Click cart button to go to ShoppingCartActivity
        onView(withId(R.id.btn_shopping_cart)).perform(click());

        // Check if the cartDrinkList is visible
        onView(withId(R.id.cartDrinkList)).check(matches(isDisplayed()));

        // Verify the order number text is shown
        onView(withId(R.id.cartOrderNumberText)).check(matches(withText("N/A")));

        // Verify total price is shown and not "$0.0"
        onView(withId(R.id.cartTotalText))
                .check(matches(allOf(isDisplayed(), not(withText("$0.0")))));
    }
}
