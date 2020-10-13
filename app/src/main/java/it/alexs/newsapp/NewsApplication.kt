package it.alexs.newsapp

import android.app.Application
import it.alexs.newsapp.di.DaggerApplicationComponent

class NewsApplication: Application() {
    val appComponent = DaggerApplicationComponent.create()
}