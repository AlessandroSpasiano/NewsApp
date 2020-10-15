package it.alexs.news_ibrary

import dagger.Module
import dagger.Provides
import it.alexs.news_ibrary.remote.FakeNewsApiService
import it.alexs.news_library.remote.NewsApiService
import javax.inject.Singleton


@Module
class FakeNewsModule  {
    @Singleton
    @Provides
    fun provideNewsApiServce(): NewsApiService {
        return FakeNewsApiService()
    }
}
