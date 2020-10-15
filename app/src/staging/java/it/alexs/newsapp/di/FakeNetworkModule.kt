package it.alexs.newsapp.di

import dagger.Module
import dagger.Provides
import it.alexs.news_ibrary.remote.FakeNewsApiService
import it.alexs.newsappnews_library.remote.NewsApiService
import javax.inject.Singleton

@Module
class FakeNetworkModule {


    @Singleton
    @Provides
    fun provideNewsApiServce(): NewsApiService {
        return FakeNewsApiService()
    }

}