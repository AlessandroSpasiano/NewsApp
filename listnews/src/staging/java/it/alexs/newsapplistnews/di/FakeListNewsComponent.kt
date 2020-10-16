package it.alexs.newsapplistnews.di

import dagger.Component
import it.alexs.newsapplistnews.ui.ListNewsActivity
import it.alexs.newsappmvvm_library.scope.ModuleScope
import it.alexs.newsappnews_ibrary.FakeNewsModule
import it.alexs.newsappnews_library.remote.NewsApiService

@ModuleScope
@Component(modules = [ListNewsViewModelModule::class, FakeNewsModule::class])
interface FakeListNewsComponent {

    fun inject(activity: ListNewsActivity)
    fun provideNewsApiService(): NewsApiService
}