package it.alexs.news_ibrary

import dagger.Module
import dagger.Provides
import it.alexs.news_ibrary.remote.FakeNewsApiService
import it.alexs.newsappmvvm_library.scope.ModuleScope
import it.alexs.newsappnews_library.remote.NewsApiService
import javax.inject.Singleton


@Module
class FakeNewsModule  {
    @ModuleScope
    @Provides
    fun provideNewsApiServce(): NewsApiService {
        return FakeNewsApiService()
    }
}
