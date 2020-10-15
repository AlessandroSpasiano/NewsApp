package it.alexs.newsapp

import android.app.Application
import it.alexs.newsapp.di.ApplicationComponent
import it.alexs.newsapp.di.DaggerApplicationComponent
open class NewsApplication: Application() {

    //private var coreLibraryComponent: CoreLibraryComponent? = null
    val appComponent by lazy { initializeComponent() }

    override fun onCreate() {
        super.onCreate()
        initializeComponent()
    }

    open fun initializeComponent(): ApplicationComponent {
        return DaggerApplicationComponent.create()
    }

}