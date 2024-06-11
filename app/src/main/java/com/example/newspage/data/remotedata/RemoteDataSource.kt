package com.example.newspage.data.remotedata

import com.example.newspage.data.network.RetrofitClient
import com.example.newspage.data.network.model.RemoteArticle
import retrofit2.Response

class RemoteDataSource() {
   suspend fun getRemoteData(queryMap: Map<String, String>):Response<RemoteArticle> {
       return RetrofitClient.newsArticleService.getNewsArticles(queryMap)
    }
}