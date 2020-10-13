package it.alexs.newsapp.service

import it.alexs.newsapp.model.Article
import it.alexs.newsapp.model.NewsWrapper

class FakeNewsApiService: NewsApiService {
    override suspend fun getTopHeadlines(country: String): NewsWrapper {
        return getNewsWrapper()
    }

    private fun getNewsWrapper(): NewsWrapper{
        val listOfArticle = mutableListOf<Article>()
        (1..100).forEach {
            listOfArticle.add(Article(
                author = "fake author $it"
                , description = "fake description of $it"
                , title = "fake title of $it"
            ))
        }
        return NewsWrapper(articles = listOfArticle)
    }
}