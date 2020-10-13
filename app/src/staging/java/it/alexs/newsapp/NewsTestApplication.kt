package it.alexs.newsapp

import it.alexs.newsapp.di.ApplicationComponent
import it.alexs.newsapp.di.DaggerTestApplicationComponent

class NewsTestApplication: NewsApplication() {

    override fun initializeComponent(): ApplicationComponent {
        return DaggerTestApplicationComponent.create()
    }
}