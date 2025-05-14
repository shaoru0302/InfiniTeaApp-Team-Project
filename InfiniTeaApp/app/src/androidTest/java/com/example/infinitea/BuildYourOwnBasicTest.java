// buildyourown feature: Scenario: UI test to verify that customizing a drink
// and confirming updates the price display correctly.
package com.example.infinitea;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import static org.hamcrest.Matchers.not;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(AndroidJUnit4.class)
public class BuildYourOwnBasicTest {

    @Rule
    public ActivityScenarioRule<BuildYourOwnActivity> activityRule =
            new ActivityScenarioRule<>(BuildYourOwnActivity.class);

    @Test
    public void testCustomizeAndPriceUpdate() {

        onView(withId(R.id.btnCustomizeDrink)).perform(click());

        onView(withText("Confirm")).perform(click());

        onView(withId(R.id.textPrice))
                .check(matches(isDisplayed()))
                .check(matches(not(withText(""))));
    }
}
