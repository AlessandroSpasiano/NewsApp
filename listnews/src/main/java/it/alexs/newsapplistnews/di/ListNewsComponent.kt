package it.alexs.newsapplistnews.di

import dagger.Component
import it.alexs.mvvm_library.scope.ModuleScope
import it.alexs.newsapp.di.ApplicationComponent
import it.alexs.newsapplistnews.ui.ListNewsActivity

@ModuleScope
@Component(dependencies = [ApplicationComponent::class], modules = [ListNewsViewModelModule::class])
interface ListNewsComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: ApplicationComponent): ListNewsComponent
    }

    fun inject(activity: ListNewsActivity)
}