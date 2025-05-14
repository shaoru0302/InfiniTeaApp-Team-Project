/**
 * MyOrdersFeature - Scenario: Verifies that when there are no past orders,
 * the "No orders found." message is shown and the RecyclerView is hidden.
 */
package com.example.infinitea;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.Visibility.GONE;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ReorderUITest {

    @Rule
    public ActivityScenarioRule<MyOrdersActivity> activityRule =
            new ActivityScenarioRule<>(MyOrdersActivity.class);

    @Test
    public void testEmptyOrderListShowsEmptyMessage() {
        // Check if empty text is shown
        onView(withId(R.id.empty_text))
                .check(matches(isDisplayed()))
                .check(matches(withText("No orders found.")));

        // Check if recyclerView is hidden
        onView(withId(R.id.orders_recycler_view))
                .check(matches(withEffectiveVisibility(GONE)));
    }
}
