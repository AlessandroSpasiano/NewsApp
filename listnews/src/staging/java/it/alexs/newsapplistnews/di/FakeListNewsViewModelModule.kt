package it.alexs.newsapplistnews.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import it.alexs.newsapplistnews.ui.FakeListNewsViewModel
import it.alexs.newsappmvvm_library.ViewModelKey

@Module
abstract class FakeListNewsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FakeListNewsViewModel::class)
    abstract fun bindFakeListNewsViewModel(fakeListNewsViewModel: FakeListNewsViewModel): ViewModel
}