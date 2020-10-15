package it.alexs.newsappnews_library.repository

import it.alexs.newsappnews_library.model.NewsWrapper
import it.alexs.newsappnews_library.remote.NewsApiService
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NewsRepository @Inject constructor(
    private val api: NewsApiService
) {

    suspend fun getTopHeadlines(country: String): NewsWrapper {
        return api.getTopHeadlines(country)
    }
}