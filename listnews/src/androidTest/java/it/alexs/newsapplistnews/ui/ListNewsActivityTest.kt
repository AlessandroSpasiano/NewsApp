package it.alexs.newsapplistnews.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import it.alexs.newsapplistnews.R
import it.alexs.newsapplistnews.adapter.NewsAdapter
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListNewsActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(TestListNewsActivity::class.java)

    @Test
    fun shouldShowListNews() {
        onView(withId(R.id.list_news)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowFakeAuthor() {
        var position = 2
        onView(withId(R.id.list_news))
            .perform(RecyclerViewActions.scrollToPosition<NewsAdapter.NewsViewHolder>(position))


        onView(
            allOf(
                withId(R.id.news_author),
                withText("di fake author $position")

            )
        ).check(matches(isDisplayed()))

        position = 50
        onView(withId(R.id.list_news))
            .perform(RecyclerViewActions.scrollToPosition<NewsAdapter.NewsViewHolder>(position))

        onView(allOf(withId(R.id.news_author), withText("di fake author $position")))
            .check(matches(isDisplayed()))
    }
}