package it.alexs.newsappnews_ibrary.repository

import it.alexs.newsappnews_library.model.NewsWrapper
import it.alexs.newsappnews_library.remote.NewsApiService
import javax.inject.Inject

class FakeNewsRepository @Inject constructor(
    private val api: NewsApiService
) {
    suspend fun getTopHeadlines(country: String): NewsWrapper {
        return api.getTopHeadlines(country)
    }
}