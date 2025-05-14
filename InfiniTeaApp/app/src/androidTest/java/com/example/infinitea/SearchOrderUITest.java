/**
 * MyOrdersFeature - Scenario: Search Past Orders
 * Espresso UI Test that verifies an error message is shown
 * when searching with an invalid or non-existent order number.
 */
package com.example.infinitea;

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

    // show error message when no order exists or invalid order
    @Test
    public void testSearchInvalidOrderNumber() {
        onView(withId(R.id.search_order_input))
                .perform(typeText("INVALID123"), closeSoftKeyboard());

        onView(withText("Order not found")).check(matches(isDisplayed()));
    }
}

