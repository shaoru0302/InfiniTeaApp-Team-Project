//Scenario 3: Modifying drink options from cart
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
public class CartLogicEspressoTest{
    @Before
    public void setup(){
        ActivityScenario.launch(MainActivity.class);
    }

    @Test
    public void testSubmitButton(){
        onView(withId(R.id.thaiButton)).check(matches(withText("Thai milk tea")));
        onView(withId(R.id.thaiButton)).perform(click());
        onView(withId(R.id.drinkText)).check(matches(withText("Thai milk tea")));

        onView(withId(R.id.iceLess)).perform(click());
        onView(withId(R.id.iceLess)).check(matches(withText("Less")));

        onView(withId(R.id.sugarNone)).perform(click());
        onView(withId(R.id.sugarNone)).check(matches(withText("None")));

        onView(withId(R.id.sizeMedium)).perform(click());
        onView(withId(R.id.sizeMedium)).check(matches(withText("Medium")));

        onView(withId(R.id.submitButton)).check(matches(isDisplayed()));
        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.sizeText)).check(matches(withText("Size: Medium")));
        onView(withId(R.id.iceText)).check(matches(withText("Ice: Less")));
        onView(withId(R.id.sugarText)).check(matches(withText("Sugar: None")));
        onView(withId(R.id.drinkText)).check(matches(withText("Drink: Thai milk tea")));

        onView(withId(R.id.modifyButton)).check(matches(isDisplayed()));
        onView(withId(R.id.modifyButton)).perform(click());

        onView(withId(R.id.sizeSmall)).perform(click());
        onView(withId(R.id.sizeSmall)).check(matches(withText("Small")));

        onView(withId(R.id.iceRegular)).perform(click());
        onView(withId(R.id.iceRegular)).check(matches(withText("Regular")));

        onView(withId(R.id.sugarHalf)).perform(click());
        onView(withId(R.id.sugarHalf)).check(matches(withText("Half")));

        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.sizeText)).check(matches(withText("Size: Small")));
        onView(withId(R.id.iceText)).check(matches(withText("Ice: Regular")));
        onView(withId(R.id.sugarText)).check(matches(withText("Sugar: Half")));
        onView(withId(R.id.drinkText)).check(matches(withText("Drink: Thai milk tea")));
    }
}