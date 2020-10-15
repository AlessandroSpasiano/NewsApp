package it.alexs.newsapplistnews.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import it.alexs.newsapplistnews.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListNewsActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(ListNewsActivity::class.java)

    @Test
    fun shouldShowListNews() {
        onView(withId(R.id.list_news)).check(matches(isDisplayed()))
    }
}