package it.alexs.newsappnews_library

import dagger.Module
import dagger.Provides
import it.alexs.newsappmvvm_library.scope.ModuleScope
import it.alexs.newsappnews_library.config.AppConfig
import it.alexs.newsappnews_library.remote.NewsApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NewsModule {

    @ModuleScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .addHeader("X-Api-Key", AppConfig.API_KEY)
                    .method(original.method, original.body)
                    .build()
                chain.proceed(request) }
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()
    }

    @ModuleScope
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @ModuleScope
    @Provides
    fun provideNewsRemoteDataService(retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }
}