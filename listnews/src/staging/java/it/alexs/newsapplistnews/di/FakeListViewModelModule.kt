package it.alexs.newsapplistnews.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import it.alexs.newsapplistnews.ui.FakeListViewModel
import it.alexs.newsappmvvm_library.ViewModelKey

@Module
abstract class FakeListViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FakeListViewModel::class)
    abstract fun bindFakeListViewModel(fakeListViewModel: FakeListViewModel): ViewModel
}