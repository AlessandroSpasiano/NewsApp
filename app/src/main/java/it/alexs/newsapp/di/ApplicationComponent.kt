package it.alexs.newsapp.di

import dagger.Component
import it.alexs.newsapp.ui.NewsActivity

@AppScope
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(activity: NewsActivity)
}