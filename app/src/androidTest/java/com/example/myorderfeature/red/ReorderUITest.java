// Scenario 3: RED – UI Test for reordering a past order
package com.example.myorderfeature;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

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
    public void testReorderButtonAddsItemToCart() {
        // tap Reorder btn
        onView(withText("Rose Bubble Milk Tea")).perform(click());
        onView(withId(R.id.btn_reorder)).perform(click());

        // check confirmed message
        onView(withText("Your drinks have been added to the cart!")).check(matches(isDisplayed()));

    }
}