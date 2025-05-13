//Scenario 1: Espresso test when selecting options for drinks
package com.example.classicdrink;

import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.action.ViewActions.click;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SelectionEspressoTest{

    @Before
    public void setup(){
        ActivityScenario.launch(SecondActivity.class);
    }

    @Test
    public void testCategoryButton(){
        onView(withId(R.id.sizeLarge)).perform(click());
        onView(withId(R.id.sizeLarge)).check(matches(withText("Large")));

        onView(withId(R.id.iceLess)).perform(click());
        onView(withId(R.id.iceLess)).check(matches(withText("Less")));

        onView(withId(R.id.sugarNone)).perform(click());
        onView(withId(R.id.sugarNone)).check(matches(withText("None")));
    }
}
