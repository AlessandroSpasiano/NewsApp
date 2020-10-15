package it.alexs.newsappnews_ibrary

import dagger.Module
import dagger.Provides
import it.alexs.newsappmvvm_library.scope.ModuleScope
import it.alexs.newsappnews_ibrary.remote.FakeNewsApiService
import it.alexs.newsappnews_library.remote.NewsApiService


@Module
class FakeNewsModule  {
    @ModuleScope
    @Provides
    fun provideNewsRemoteDataService(): NewsApiService {
        return FakeNewsApiService()
    }
}
