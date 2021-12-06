package com.example.EspressoUITestExamples

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun test_isActivityInView() {

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_title_nextButton() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))

        // Method 1
        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))

        // Method 2
        onView(withId(R.id.button_next_activity)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

    }

    @Test
    fun text_isTitleTextDisplayed() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // Testing is text same as intended
        onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)))
    }

    @Test
    fun test_navSecondaryActivity() {

        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button_next_activity))
            .perform(click())

        onView(withId(R.id.secondary))
            .check(matches(isDisplayed()))

    }

    @Test
    fun test_backPress_toMainActivity() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button_next_activity))
            .perform(click())

        onView(withId(R.id.secondary))
            .check(matches(isDisplayed()))

        // Method 1
        // back btn in layout pressed
//        onView(withId(R.id.button_back))
//            .perform(click())

        // System back btn pressed
        // Method 2
        pressBack()

        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }
}