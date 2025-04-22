// Scenario 4: RED – UI Test for Reordering a Past Order with Out-of-Stock Items
package com.example.myorderfeature.red;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.CoreMatchers.not;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ReorderOutOfStockTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testReorderWithOutOfStockItems() {
        onView(withId(R.id.btn_my_orders)).perform(click());

        onView(withText("Rose bubble milk tea")).perform(click());
        onView(withId(R.id.btn_reorder)).perform(click());

        onView(withText("Some items are out of stock")).check(matches(isDisplayed()));

        onView(withId(R.id.btn_reorder)).perform(click());
        onView(withText("Your updated order has been added to the cart!")).check(matches(isDisplayed()));
        onView(withId(R.id.cart_total_price)).check(matches(not(withText("$0.00"))));
    }
}
