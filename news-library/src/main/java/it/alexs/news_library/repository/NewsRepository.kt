package it.alexs.news_library.repository

import it.alexs.news_library.model.NewsWrapper
import it.alexs.news_library.remote.NewsRemoteDataSource
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val api: NewsRemoteDataSource
) {

    suspend fun getTopHeadlines(country: String): NewsWrapper{
        return api.getTopHeadlines(country)
    }
}