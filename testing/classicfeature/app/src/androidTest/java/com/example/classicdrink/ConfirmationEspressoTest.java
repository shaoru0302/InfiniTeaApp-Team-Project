//Scenario 2: Adding drink to cart
package com.example.classicdrink;

import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
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
public class ConfirmationEspressoTest{

    @Before
    public void setup(){
        ActivityScenario.launch(SecondActivity.class);
    }

    @Test
    public void testSubmitButton(){
        onView(withId(R.id.sizeLarge)).perform(click());
        onView(withId(R.id.sizeLarge)).check(matches(withText("Large")));

        onView(withId(R.id.iceLess)).perform(click());
        onView(withId(R.id.iceLess)).check(matches(withText("Less")));

        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.submitButton)).check(matches(withText("Submit")));

        onView(withId(R.id.sugarNone)).perform(click());
        onView(withId(R.id.sugarNone)).check(matches(withText("None")));

        onView(withId(R.id.sizeMedium)).perform(click());
        onView(withId(R.id.sizeMedium)).check(matches(withText("Medium")));

        onView(withId(R.id.submitButton)).check(matches(isDisplayed()));
        onView(withId(R.id.submitButton)).perform(click());
        //onView(withId(R.id.submitButton)).check(matches(withText("Submit")));
        //onView(withText("Size: Large")).check(matches(isDisplayed()));
        onView(withId(R.id.sizeText)).check(matches(withText("Size: Medium")));
        onView(withId(R.id.iceText)).check(matches(withText("Ice: Less")));
        onView(withId(R.id.sugarText)).check(matches(withText("Sugar: None")));
    }
}