// Scenario 1: RED: test for Start Order menu UI
package com.example.classicdrinkfeature;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.intent.Intents;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class StartOrderUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testStartOrderFlow() {

        onView(withId(R.id.btn_start_order)).perform(click());

        onView(withText("Thai Bubble Milk Tea")).check(matches(isDisplayed()));
        onView(withText("Select Size")).check(matches(isDisplayed()));
        onView(withText("Select Sugar Level")).check(matches(isDisplayed()));
        onView(withText("Select Ice Level")).check(matches(isDisplayed()));
    }
}
