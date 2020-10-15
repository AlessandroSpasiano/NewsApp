package it.alexs.newsapp

import android.app.Application
import it.alexs.newsapp.di.DaggerApplicationComponent
import it.alexs.newsappcore_library.di.CoreLibraryComponent
import it.alexs.newsappcore_library.di.DaggerCoreLibraryComponent

open class NewsApplication: Application() {

    private var coreLibraryComponent: CoreLibraryComponent? = null

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder()
            .coreLibraryComponent(coreLibraryComponent())
            .build()
    }

    fun coreLibraryComponent(): CoreLibraryComponent {
        if(coreLibraryComponent == null){
            coreLibraryComponent = DaggerCoreLibraryComponent.builder()
                .application(this)
                .build()
        }
        return coreLibraryComponent!!
    }

}