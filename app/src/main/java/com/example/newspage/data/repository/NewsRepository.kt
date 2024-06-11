package com.example.newspage.data.repository

import com.example.newspage.data.model.Article
import com.example.newspage.data.remotedata.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NewsRepository(private val remoteDataSource: RemoteDataSource = RemoteDataSource()) {

    suspend fun getNewsArticles(queryMap: Map<String, String>): Flow<List<Article>> = flow {
        val response = remoteDataSource.getRemoteData(queryMap)
        val articleList:MutableList<Article> = mutableListOf()
        for (article in response.articles) {
            articleList.add(
                Article(
                    article.title,
                    article.urlToImage,
                    article.description,
                    article.content,
                    article.author
                )
            )
        }
        emit(articleList)
    }.flowOn(Dispatchers.IO)
}