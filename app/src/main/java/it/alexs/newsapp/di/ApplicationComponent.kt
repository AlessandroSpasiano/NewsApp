package it.alexs.newsapp.di

import dagger.Component
import it.alexs.newsappnews_library.NewsModule
import it.alexs.newsappnews_library.repository.NewsRepository
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    NewsModule::class]
)
interface ApplicationComponent {
    fun provideNewsRepository(): NewsRepository
}