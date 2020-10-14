package it.alexs.newsapp.di

import dagger.Module
import dagger.Provides
import it.alexs.news_library.remote.NewsApiService
import it.alexs.newsapp.service.FakeNewsApiService
import javax.inject.Singleton

@Module
class FakeNetworkModule {


    @Singleton
    @Provides
    fun provideNewsApiServce(): NewsApiService {
        return FakeNewsApiService()
    }

}