package com.example.infiniteashoppingcart;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.action.ViewActions.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(AndroidJUnit4.class)

public class CartOrderFlowAndUIDisplayTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testOrderFlowShowsReceiptDetails() throws InterruptedException {
        onView(withId(R.id.cartButton)).perform(click());
        onView(withId(R.id.recyclerView))
                .check(matches(hasMinimumChildCount(1)));
        onView(withId(R.id.orderButton)).perform(click());
        onView(withId(R.id.orderIdText)).check(matches(isDisplayed()));
        onView(withId(R.id.dateDetails)).check(matches(isDisplayed()));
        onView(withId(R.id.recyclerView2)).check(matches(hasMinimumChildCount(1)));
        onView(withId(R.id.totalPrice2))
                .check(matches(allOf(isDisplayed(), not(withText("Total: $ 0.0")))));
    }
}
