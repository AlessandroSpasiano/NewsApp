package it.alexs.newsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import it.alexs.newsapp.config.AppConfig
import it.alexs.newsapp.databinding.ActivityNewsBinding
import it.alexs.newsapp.model.Article
import it.alexs.newsapp.service.NewsService
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNewsBinding.inflate(layoutInflater)
    }

    private val adapter by lazy { NewsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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

        val newsService = retrofit.create(NewsService::class.java)
        setRecyclerView()
        getNews(newsService)
    }

    private fun setRecyclerView(){
        binding.news.layoutManager = LinearLayoutManager(this)
        binding.news.adapter = adapter
    }

    private fun getNews(service: NewsService) {
        runBlocking {
            adapter.submitList(service.getTopHeadlines(
                "it"
            ).articles)
        }
    }
}