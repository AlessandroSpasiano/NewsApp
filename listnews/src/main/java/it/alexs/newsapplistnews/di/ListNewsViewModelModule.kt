package it.alexs.newsapplistnews.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import it.alexs.newsapplistnews.ui.ListNewsViewModel
import it.alexs.newsappmvvm_library.ViewModelKey

@Module
abstract class ListNewsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListNewsViewModel::class)
    abstract fun bindListNewsViewModel(listNewsViewModel: ListNewsViewModel): ViewModel
}