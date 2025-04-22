package com.example.myorderfeature;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.CoreMatchers.not;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class OutOfStockTest{

    @Rule
    public ActivityScenarioRule<MainActivity> mainRule =
            new ActivityScenarioRule<>(MainActivity.class);

    //Selecting while not available
    @Test
    public void outOfStock(){
        onView(withId(R.id.btn_classic_menu)).perform(click());

        onView(withText("Rose bubble milk tea")).perform(click());
        onView(withId(R.id.btn_drink)).perform(click());
        onView(withText("This item is out of stock")).check(matches(isDisplayed()));
    }
}