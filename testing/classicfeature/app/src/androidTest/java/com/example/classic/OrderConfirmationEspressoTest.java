//Scenario 3: Espresso Test
package com.example.classicdrinkfeature;

import android.view.View;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.action.ViewActions.*;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DrinkOrderTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup() {
        bubbleTeaList = new ArrayList<>();
        bubbleTeaList.add(new BubbleTea("Thai milk tea", 6, 2,
                DrinkSize.LARGE, Topping.Bubble, IceLevel.Default, SugarLevel.Half));
    }

    // Successful drink.
    @Test
    public void testAddToCartSuccess() {
        onView(withId(R.id.size_button)).perform(click());
        onView(withText("Large")).perform(click());

        onView(withId(R.id.topping_button)).perform(click());
        onView(withText("Bubble")).perform(click());

        onView(withId(R.id.ice_button)).perform(click());
        onView(withText("Default Ice")).perform(click());

        onView(withId(R.id.sugar_button)).perform(click());
        onView(withText("50% Sugar")).perform(click());

        onView(withId(R.id.add_to_cart_button)).perform(click());
        onView(withId(R.id.confirmation_message))
                .check(ViewAssertions.matches(withText("Added to Cart")));
    }

    // Size option is missing
    @Test
    public void testAddToCartFailWhenSizeMissing() {
        onView(withId(R.id.topping_button)).perform(click());
        onView(withText("Bubble")).perform(click());

        onView(withId(R.id.ice_button)).perform(click());
        onView(withText("Default Ice")).perform(click());

        onView(withId(R.id.sugar_button)).perform(click());
        onView(withText("50% Sugar")).perform(click());

        onView(withId(R.id.add_to_cart_button)).perform(click());
        onView(withId(R.id.error_message))
                .check(ViewAssertions.matches(withText("Please select a size option")));
    }

    // Topping is missing
    @Test
    public void testAddToCartFailWhenToppingMissing(){
        onView(withId(R.id.size_button)).perform(click());
        onView(withText("Large")).perform(click());

        onView(withId(R.id.ice_button)).perform(click());
        onView(withText("Default Ice")).perform(click());

        onView(withId(R.id.sugar_button)).perform(click());
        onView(withText("50% Sugar")).perform(click());

        onView(withId(R.id.add_to_cart_button)).perform(click());
        onView(withId(R.id.error_message))
            .check(ViewAssertions.matches(withText("Please select a topping option")));
    }
    
    // Ice level is missing
    @Test
    public void testAddToCartFailWhenIceMissing() {
        onView(withId(R.id.size_button)).perform(click());
        onView(withText("Large")).perform(click());

        onView(withId(R.id.topping_button)).perform(click());
        onView(withText("Bubble")).perform(click());

        onView(withId(R.id.sugar_button)).perform(click());
        onView(withText("50% Sugar")).perform(click());

        onView(withId(R.id.add_to_cart_button)).perform(click());
        onView(withId(R.id.error_message))
                .check(ViewAssertions.matches(withText("Please select a ice option")));
    }

    // Sugar level is missing
    @Test
    public void testAddToCartFailWhenSugarMissing() {
        onView(withId(R.id.size_button)).perform(click());
        onView(withText("Large")).perform(click());

        onView(withId(R.id.topping_button)).perform(click());
        onView(withText("Bubble")).perform(click());

        onView(withId(R.id.ice_button)).perform(click());
        onView(withText("Default Ice")).perform(click());

        onView(withId(R.id.add_to_cart_button)).perform(click());
        onView(withId(R.id.error_message))
                .check(ViewAssertions.matches(withText("Please select a sugar option")));
    }
}
