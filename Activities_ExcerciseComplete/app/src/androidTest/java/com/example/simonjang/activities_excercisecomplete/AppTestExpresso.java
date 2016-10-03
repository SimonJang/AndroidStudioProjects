package com.example.simonjang.activities_excercisecomplete;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by simonjang on 3/10/16.
 */

@RunWith(AndroidJUnit4.class)
public class AppTestExpresso {
    @Rule
    public ActivityTestRule<Activity1> mActivityRule = new ActivityTestRule<>(Activity1.class);

    @Test
    public void ensureTextChangesWork() {
        onView(withId(R.id.start)).check(matches(withText("onStart(): 1")));
    }
    // Controleert of de activity veranderd is. Dit door de id van de button de controleren die
    // deel uitmaakt van de 2e activity
    @Test
    public void buttonOnClickChangesActivity() {
        onView(withId(R.id.bLaunchActivityTwo)).perform(click());
        onView(withId(R.id.bLaunchActivityOne)).check(matches(withText("Start Activity One")));
    }
}
