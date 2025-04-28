package com.example.infiniteashoppingcart;

// Scenario 1: RED – UI Test for access the Cart and view the content of items.
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CartDisplayItemUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);



    @Test
    public void testNavigateToCartAndSeeItem() {
        onView(withId(R.id.cartButton)).perform(click());
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));
    }
}
