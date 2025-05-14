/**
 * MyOrdersFeature - Scenario: View Past Orders Entry Point
 * Espresso UI Test that verifies clicking the "My Orders" button
 * successfully navigates to the MyOrdersActivity and displays the search bar.
 */
package com.example.infinitea;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class ViewPastOrdersUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    // Test: clicking My Orders button should show the search bar
    @Test
    public void testAccessPastOrders() {
        onView(withId(R.id.btn_my_orders)).perform(click());
        onView(withId(R.id.search_order_input)).check(matches(isDisplayed()));
    }
}
