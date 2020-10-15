package it.alexs.newsapplistnews.di

import dagger.Component
import it.alexs.newsapp.di.TestApplicationComponent
import it.alexs.newsappmvvm_library.scope.ModuleScope
import it.alexs.newsappnews_ibrary.FakeNewsModule
import it.alexs.newsappnews_library.remote.NewsApiService

@ModuleScope
@Component(dependencies = [TestApplicationComponent::class], modules = [FakeNewsModule::class])
interface FakeListNewsComponent {
    @Component.Factory
    interface Factory {
        fun create(appCompat: TestApplicationComponent): FakeListNewsComponent
    }
    fun provideNewsApiService(): NewsApiService
}