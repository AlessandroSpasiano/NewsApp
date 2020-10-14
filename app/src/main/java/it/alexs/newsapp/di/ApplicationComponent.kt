package it.alexs.newsapp.di

import dagger.Component
import it.alexs.newsapp.ui.NewsActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, NewsViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: NewsActivity)
}