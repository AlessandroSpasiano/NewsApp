package it.alexs.newsapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import it.alexs.newsapp.model.NewsWrapper
import it.alexs.newsapp.model.ResultWrapper
import it.alexs.newsapp.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel() {

    fun getTopHeadlinse(country: String): LiveData<ResultWrapper<NewsWrapper>>{
        return liveData(Dispatchers.IO){
            emit(newsRepository.getTopHeadlines(country))
        }
    }
}