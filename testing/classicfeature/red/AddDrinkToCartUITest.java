//scenario 3: Red - for placing an order and showing confirmation
package com.example.classicdrinkfeature;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;

@RunWith(AndroidJUnit4.class)
public class AddDrinkToCartUITest {

    @Rule
    public ActivityScenarioRule<StartOrderActivity> activityRule =
            new ActivityScenarioRule<>(StartOrderActivity.class);

    @Test
    public void testPlaceOrderFlow() {
        onView(withText("Thai Bubble Milk Tea")).perform(click());
        onView(withId(R.id.btn_add_to_cart)).perform(click());
        onView(withText("Yes")).perform(click());
        onView(withText("Success and THANK YOU")).check(matches(isDisplayed()));
    }
}
