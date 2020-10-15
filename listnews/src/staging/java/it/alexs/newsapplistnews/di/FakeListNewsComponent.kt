package it.alexs.newsapplistnews.di

import dagger.Component
import it.alexs.news_ibrary.FakeNewsModule
import it.alexs.news_ibrary.remote.FakeNewsApiService
import it.alexs.newsappmvvm_library.scope.ModuleScope
import it.alexs.newsappnews_library.remote.NewsApiService

@ModuleScope
@Component(modules = [FakeNewsModule::class])
interface FakeListNewsComponent {

    fun provideNewsApiService(): NewsApiService
}