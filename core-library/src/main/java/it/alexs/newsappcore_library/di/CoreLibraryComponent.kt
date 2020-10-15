package it.alexs.newsappcore_library.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreLibraryModule::class])
interface CoreLibraryComponent {

    @Component.Builder interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): CoreLibraryComponent
    }
}