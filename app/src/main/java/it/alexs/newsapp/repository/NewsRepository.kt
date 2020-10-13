package it.alexs.newsapp.repository

import it.alexs.newsapp.model.NewsWrapper
import it.alexs.newsapp.model.ResultWrapper
import it.alexs.newsapp.service.NewsApiService
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val apiService: NewsApiService
) {

    suspend fun getTopHeadlines(country: String): ResultWrapper<NewsWrapper>{
        return try {
            ResultWrapper.Success(apiService.getTopHeadlines(country))
        } catch (e: Throwable){
            when(e){
                is HttpException -> ResultWrapper.Error(
                    ResultWrapper.GenericError(
                        e.code(),
                        e.message()
                    )
                )
                else -> ResultWrapper.Error(ResultWrapper.GenericError(500, "Errore imprevisto"))
            }
        }
    }
}