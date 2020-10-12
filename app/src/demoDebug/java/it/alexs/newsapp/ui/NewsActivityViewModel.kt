package it.alexs.newsapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import it.alexs.newsapp.config.AppConfig
import it.alexs.newsapp.model.NewsWrapper
import it.alexs.newsapp.service.NewsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsActivityViewModel: ViewModel() {

    private lateinit var service: NewsService
    init {
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .addHeader("X-Api-Key", AppConfig.API_KEY)
                    .method(original.method(), original.body())
                    .build()
                chain.proceed(request)
            }
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(AppConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        service = retrofit.create(NewsService::class.java)
    }

    fun getNews(): LiveData<NewsWrapper> {
        return liveData {
            emit(service.getTopHeadlines("it"))
        }
    }
}