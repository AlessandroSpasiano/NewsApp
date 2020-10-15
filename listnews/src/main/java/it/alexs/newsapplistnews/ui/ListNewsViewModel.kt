package it.alexs.newsapplistnews.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import it.alexs.news_library.model.NewsWrapper
import it.alexs.news_library.repository.NewsRepository
import it.alexs.newsappcommon_library.extensions.resultWrapperCatching
import it.alexs.newsappcommon_library.model.ResultWrapper
import it.alexs.newsappmvvm_library.scope.ModuleScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@ModuleScope
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