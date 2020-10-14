package it.alexs.news_library.remote

import it.alexs.news_library.model.NewsWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsRemoteDataSource {

    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") country: String): NewsWrapper
}