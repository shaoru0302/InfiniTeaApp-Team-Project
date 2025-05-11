//Scenario 2: Espresso test 
package com.example.classicdrinkfeature;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DrinkSelectionTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup() {
        bubbleTeaList = new ArrayList<>();
        bubbleTeaList.add(new BubbleTea("Thai milk tea", 6, 2,
                DrinkSize.LARGE, Topping.Bubble, IceLevel.Default, SugarLevel.Half));
    }

    @Test
    public void testDrinkIsAvailable() {
        onView(withId(R.id.recyclerView))
                .perform(ViewActions.scrollTo())
                .check(ViewAssertions.matches(ViewMatchers.hasDescendant(withText("Thai Bubble Milk Tea"))));
    }

    @Test
    public void testCreateDrink() {
        onView(withText("Thai Bubble Milk Tea"))
                .perform(ViewActions.click());

        onView(withId(R.id.size_button))
                .perform(ViewActions.click());
        onView(withText("Large")).perform(ViewActions.click());

        onView(withId(R.id.topping_button))
                .perform(ViewActions.click());
        onView(withTest("Bubble")).perform(ViewActions.click());

        onView(withId(R.id.ice_button))
                .perform(ViewActions.click());
        onView(withText("Default")).perform(ViewActions.click());

        onView(withId(R.id.sugar_button))
                .perform(ViewActions.click());
        onView(withText("Half")).perform(ViewActions.click());

        onView(withId(R.id.drink_summary))
                .check(ViewAssertions.matches(withText("Thai Bubble Milk Tea - Large, Bubble, Default Ice, Half Sugar")));
    }
}
