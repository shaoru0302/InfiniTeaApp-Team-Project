package com.example.infiniteashoppingcart;
//Scenario 2: RED – UI Test for alert remove all item and alert message for remove
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

@RunWith(AndroidJUnit4.class)
public class CartRemoveAllUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testRemoveAllClearsCart() {
        onView(withId(R.id.cartButton)).perform(click());
        onView(withId(R.id.removeAll)).perform(click());
        onView(withId(R.id.overLayBlocker)).check(matches(isDisplayed()));
        onView(withId(R.id.confirmButton)).perform(click());
        onView(withId(R.id.totalPrice)).check(matches(withText("Total: $ 0.0")));
    }
}
