// Scenario 2: RED – UI Test for searching and filtering past orders
package com.example.myorderfeature.red;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SearchOrderUITest {

    @Rule
    public ActivityScenarioRule<MyOrdersActivity> activityRule =
            new ActivityScenarioRule<>(MyOrdersActivity.class);

    @Test
    public void testSearchValidOrderNumber() {
        onView(withId(R.id.search_order_input)).perform(typeText("ORD001"), closeSoftKeyboard());
        onView(withText("Bubble Milk Tea")).check(matches(isDisplayed()));
    }

    @Test
    public void testSearchInvalidOrderNumber() {
        onView(withId(R.id.search_order_input)).perform(typeText("INVALID123"), closeSoftKeyboard());
        onView(withText("Order not found")).check(matches(isDisplayed()));
    }
}
