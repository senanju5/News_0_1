package com.example.newspage.data.remotedata

import com.example.newspage.data.network.RetrofitClient
import com.example.newspage.data.network.model.RemoteArticle

class RemoteDataSource() {
   suspend fun getRemoteData(queryMap: Map<String, String>):RemoteArticle {
       return RetrofitClient.newsArticleService.getNewsArticles(queryMap)
    }
}