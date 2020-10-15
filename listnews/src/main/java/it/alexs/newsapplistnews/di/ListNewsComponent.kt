package it.alexs.newsapplistnews.di

import dagger.Component
import it.alexs.newsappcore_library.di.CoreLibraryComponent
import it.alexs.newsapplistnews.ui.ListNewsActivity
import it.alexs.newsappmvvm_library.scope.ModuleScope
import it.alexs.newsappnews_library.NewsModule
import it.alexs.newsappnews_library.remote.NewsApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@ModuleScope
@Component(dependencies = [CoreLibraryComponent::class], modules = [ListNewsViewModelModule::class, NewsModule::class])
interface ListNewsComponent {

    @Component.Builder
    interface Builder {
        fun build(): ListNewsComponent
        fun provideCoreLibraryComponent(component: CoreLibraryComponent): Builder
    }

    fun inject(activity: ListNewsActivity)

    fun provideRetrofit(): Retrofit
    fun provideOkHttp(): OkHttpClient
    fun provideNewsApiService(): NewsApiService
}