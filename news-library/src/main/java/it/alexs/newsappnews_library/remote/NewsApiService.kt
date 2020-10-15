package it.alexs.newsappnews_library.remote

import it.alexs.newsappnews_library.model.NewsWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") country: String): NewsWrapper
}