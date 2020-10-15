package it.alexs.newsapplistnews.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import it.alexs.newsappcommon_library.extensions.resultWrapperCatching
import it.alexs.newsappcommon_library.model.ResultWrapper
import it.alexs.newsappnews_library.model.NewsWrapper
import it.alexs.newsappnews_library.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ListNewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel() {

    fun getTopHeadlines(country: String): LiveData<ResultWrapper<NewsWrapper>>{
        return liveData(Dispatchers.IO){
            val result = resultWrapperCatching { newsRepository.getTopHeadlines(country) }
            emit(result)
        }
    }
}