// buildyourown feature: Scenario: UI test to confirm that Available Toppings
// and Selected Toppings list views are visible.
package com.example.infinitea;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class BuildYourOwnToppingsUITest {

    @Rule
    public ActivityScenarioRule<BuildYourOwnActivity> activityRule =
            new ActivityScenarioRule<>(BuildYourOwnActivity.class);

    @Test
    public void testToppingsListViewsAreVisible() {
        // Available Toppings ListView
        onView(withId(R.id.listAvailableToppings))
                .check(matches(isDisplayed()));

        // Selected Toppings ListView
        onView(withId(R.id.listSelectedToppings))
                .check(matches(isDisplayed()));
    }
}
