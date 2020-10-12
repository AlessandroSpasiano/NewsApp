package it.alexs.newsapp.service

import it.alexs.newsapp.model.NewsWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") country: String): NewsWrapper
}