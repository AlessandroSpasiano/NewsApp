package it.alexs.newsapp

import android.app.Application
import it.alexs.newsapp.di.ApplicationComponent
import it.alexs.newsapp.di.DaggerApplicationComponent

open class NewsApplication: Application() {

    val appComponent: ApplicationComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): ApplicationComponent {
        return DaggerApplicationComponent.create()
    }
}