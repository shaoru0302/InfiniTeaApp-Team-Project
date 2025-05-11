//Scenario 1: Espresso test
package com.example.classicdrinkfeature;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.CoreMatchers.allOf;

public class MenuDrinkDisplayTest {

    @Rule
    public ActivityScenarioRule<YourActivity> activityScenarioRule = new ActivityScenarioRule<>(YourActivity.class);

    @Before
    public void setUp() {
        bubbleTeaList = new ArrayList<>();
        bubbleTeaList.add(new BubbleTea("Thai milk tea", 6, 2,
                DrinkSize.LARGE, Topping.Bubble, IceLevel.Defualt, SugarLevel.Half));
    }

    @Test
    public void testDrinkNameIsDisplayed() {
        onView(withId(R.id.recycler_view_drinks))
            .perform(scrollToPosition(0));

        onView(allOf(withId(R.id.drink_name_textview), withText("Thai Bubble Milk Tea")))
            .check(matches(ViewMatchers.isDisplayed()));
    }
}
