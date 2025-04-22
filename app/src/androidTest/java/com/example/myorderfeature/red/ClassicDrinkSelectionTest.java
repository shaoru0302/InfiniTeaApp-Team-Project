// Scenario 2: RED – UI Test for selecting an option for a drink
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
public class DrinkSelectionTest{

    @Rule
    public ActivityScenarioRule<MainActivity> mainRule =
            new ActivityScenarioRule<>(MainActivity.class);

    //Selecting drink
    @Test
    public void selectButton(){
        onView(withText("Rose Bubble Milk Tea")).perform(click());
        onview(withId(R.id.btn_select)).perform(click());

        //For testing
        onView(withId(R.id.selection_confirmation)).check(matches(isDisplayed()));
    }
}