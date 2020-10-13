package it.alexs.newsapp.di

import dagger.Module
import dagger.Provides
import it.alexs.newsapp.service.FakeNewsApiService
import it.alexs.newsapp.service.NewsApiService
import javax.inject.Singleton

@Module
class FakeNetworkModule {


    @Singleton
    @Provides
    fun provideNewsApiServce(): NewsApiService{
        return FakeNewsApiService()
    }

}