package com.pereira.tiago.desafioviavarejo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val mActivityRule = ActivityTestRule(MainActivity::class.java, false, true)

    @Test
    fun whenActivityIsLaunched_shouldDisplayInitialState() {
        onView(withId(R.id.drawer_layout)).check(matches(isDisplayed()))
        onView(withId(R.id.nav_view)).check(matches(not(isDisplayed())))
    }

}