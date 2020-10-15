package it.alexs.newsapplistnews.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import it.alexs.newsappnews_library.model.NewsWrapper
import it.alexs.newsappnews_library.repository.NewsRepository
import it.alexs.newsappcommon_library.extensions.resultWrapperCatching
import it.alexs.newsappcommon_library.model.ResultWrapper
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class FakeListNewsViewModel @Inject constructor(
    private val repository: NewsRepository
): ViewModel(){

    fun getTopHeadlines(country: String): LiveData<ResultWrapper<NewsWrapper>> {
        return liveData(Dispatchers.IO){
            val result = resultWrapperCatching { repository.getTopHeadlines(country) }
            emit(result)
        }
    }
}