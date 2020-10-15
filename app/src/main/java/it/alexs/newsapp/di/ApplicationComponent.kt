package it.alexs.newsapp.di

import dagger.Component
import it.alexs.newsapp.ui.NewsActivity
import it.alexs.newsappcore_library.di.CoreLibraryComponent
import it.alexs.newsappcore_library.interfaces.BaseActivityComponent
import it.alexs.newsappmvvm_library.scope.AppScope

@AppScope
@Component(dependencies = [CoreLibraryComponent::class])
interface ApplicationComponent: BaseActivityComponent<NewsActivity> {

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent
        fun coreLibraryComponent(coreLibraryComponent: CoreLibraryComponent): Builder
    }
}