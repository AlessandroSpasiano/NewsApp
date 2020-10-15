package it.alexs.newsapp.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import it.alexs.newsapp.R
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NewsActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(NewsActivity::class.java)

    @Test
    fun shouldShowButton() {
        onView(withId(R.id.news_get_news)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldButtonText() {
        onView(
            allOf(
                withId(R.id.news_get_news),
                withText("Show news")
            )
        ).check(matches(isDisplayed()))
    }
}