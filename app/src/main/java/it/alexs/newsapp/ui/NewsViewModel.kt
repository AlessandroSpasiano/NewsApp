package it.alexs.newsapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import it.alexs.news_library.model.NewsWrapper
import it.alexs.news_library.repository.NewsRepository
import it.alexs.newsapp.extensions.resultWrapperCatching
import it.alexs.newsapp.model.ResultWrapper
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel() {

    fun getTopHeadlinse(country: String): LiveData<ResultWrapper<NewsWrapper>>{
        return liveData(Dispatchers.IO){
            val result = resultWrapperCatching { newsRepository.getTopHeadlines(country) }
            emit(result)
        }
    }
}