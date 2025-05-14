// classicdrink feature: Scenario: Espresso test for selecting size/sugar/ice for classic drink
package com.example.infinitea;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ClassicDrinkSelectionEspressoTest {

    @Before
    public void launchActivity() {
        ActivityScenario.launch(ChooseDrinkActivity.class);
    }

    @Test
    public void testCustomizeDrinkOptions() {

        onView(withId(R.id.drinkRecyclerView))
                .perform(androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition(0, click()));

        // select Size、Sugar、Ice Spinner
        onView(withId(R.id.spinnerSize)).perform(click());
        onView(withText("M")).perform(click());

        onView(withId(R.id.spinnerSugar)).perform(click());
        onView(withText("50%")).perform(click());

        onView(withId(R.id.spinnerIce)).perform(click());
        onView(withText("100%")).perform(click());

        // check if each Spinner set up correctly
        onView(withId(R.id.spinnerSize)).check(matches(withSpinnerText(containsString("M"))));
        onView(withId(R.id.spinnerSugar)).check(matches(withSpinnerText(containsString("50%"))));
        onView(withId(R.id.spinnerIce)).check(matches(withSpinnerText(containsString("100%"))));
    }
}
