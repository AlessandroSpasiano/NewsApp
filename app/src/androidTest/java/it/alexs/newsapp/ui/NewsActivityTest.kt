package it.alexs.newsapp.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import it.alexs.newsapp.R
import it.alexs.newsapp.adapter.NewsAdapter
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NewsActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(NewsActivity::class.java)

    @Test
    fun shouldShowListOfArticles() {
        onView(withId(R.id.news)).check(matches(isDisplayed()))
    }


    @Test
    fun shouldShowThatAuthorIsCorrect() {
        var position = 2
        onView(withId(R.id.news))
            .perform(RecyclerViewActions.scrollToPosition<NewsAdapter.NewsViewHolder>(position))


        onView(
            allOf(
                withId(R.id.news_author),
                withText("di fake author $position")

            )
        ).check(matches(isDisplayed()))

        position = 50
        onView(withId(R.id.news))
            .perform(RecyclerViewActions.scrollToPosition<NewsAdapter.NewsViewHolder>(position))

        onView(allOf(withId(R.id.news_author), withText("di fake author $position")))
            .check(matches(isDisplayed()))
    }
}