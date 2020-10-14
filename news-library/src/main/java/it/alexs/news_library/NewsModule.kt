package it.alexs.news_library

import dagger.Module
import dagger.Provides
import it.alexs.news_library.remote.NewsRemoteDataSource
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NewsModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataService(retrofit: Retrofit): NewsRemoteDataSource{
        return retrofit.create(NewsRemoteDataSource::class.java)
    }
}