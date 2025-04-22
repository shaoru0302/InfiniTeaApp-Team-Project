// Scenario 1:RED --UI Test for accessing the menu page
package com.example.classicfeature;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.intent.Intents;
import org.jetbrains.annotations.TestOnly;
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

import androidx.core.app.RemoteInput; ...

@RunWith(AndroidJUnit4.class)
public class classicUiTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp(){ Intents.init();}

    @After
    public void tearDown(){ Intents.release();}

    //Viewing the classic menu page
    @Test
    public void testAccessMenu(){
        onView(withId(R.id.btn_classic_menu)).perform(click());
        onView(withId(R.id.classic_recycler_view).check(matches(isDisplayed()))
    }
}