package com.example.newspage.data.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.newspage.data.model.Article
import com.example.newspage.data.paging.ArticlePagingSource
import com.example.newspage.data.remotedata.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewsRepository(private val remoteDataSource: RemoteDataSource = RemoteDataSource()) {

   private fun getArticles(queryMap: HashMap<String, String>): Flow<PagingData<com.example.newspage.data.network.model.Article>> = Pager (
        config = PagingConfig(pageSize = 1, maxSize = 10),
        pagingSourceFactory = { ArticlePagingSource(remoteDataSource, queryMap) }

    ).flow

     fun getNewsArticles(queryMap: HashMap<String, String>): Flow<PagingData<Article>> = getArticles(queryMap).map {
            it.map {
                Article(
                    it.title,
                    it.urlToImage,
                    it.description,
                    it.content,
                    it.author)
            }
    }
}