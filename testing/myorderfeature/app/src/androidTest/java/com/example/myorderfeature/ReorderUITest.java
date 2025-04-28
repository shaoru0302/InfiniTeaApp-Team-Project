// Scenario 3: Espresso test for handling and reordering in stock and out of stock item
package com.example.myorderfeature;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ReorderUITest {

    @Rule
    public ActivityScenarioRule<MyOrdersActivity> activityRule =
            new ActivityScenarioRule<>(MyOrdersActivity.class);

    // check if add to cart successfully
    @Test
    public void testReorderSuccessWithInStockItems() {
        onView(withId(R.id.search_order_input)).perform(typeText("ORD001"));
        onView(withId(R.id.reorder_button)).perform(click());

        onView(withId(R.id.status_text))
                .check(matches(isDisplayed()))
                .check(matches(withText(Matchers.containsString("In-stock items added to cart"))));
    }

    // search and test for the order with all out of stock items（e.g. ORD004）
    @Test
    public void testReorderWithOnlyOutOfStockItems() {

        onView(withId(R.id.search_order_input)).perform(typeText("ORD004"));
        onView(withId(R.id.reorder_button)).perform(click());

        onView(withId(R.id.status_text))
                .check(matches(isDisplayed()))
                .check(matches(withText("No available items to reorder.")));
    }
}
