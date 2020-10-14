package it.alexs.news_library.repository

import it.alexs.news_library.model.NewsWrapper
import it.alexs.news_library.remote.NewsApiService
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val api: NewsApiService
) {

    suspend fun getTopHeadlines(country: String): NewsWrapper{
        return api.getTopHeadlines(country)
    }
}