package it.alexs.newsappnews_ibrary.remote

import it.alexs.newsappnews_library.model.Article
import it.alexs.newsappnews_library.model.NewsWrapper
import it.alexs.newsappnews_library.remote.NewsApiService

class FakeNewsApiService: NewsApiService {
    override suspend fun getTopHeadlines(country: String): NewsWrapper {
        return getNewsWrapper()
    }

    private fun getNewsWrapper(): NewsWrapper {
        val listOfArticle = mutableListOf<Article>()
        (1..100).forEach {
            listOfArticle.add(
                Article(
                author = "fake author $it"
                , description = "fake description of $it"
                , title = "fake title of $it"
            )
            )
        }
        return NewsWrapper(articles = listOfArticle)
    }
}