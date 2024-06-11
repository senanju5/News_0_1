package com.example.newspage.data.network

import com.example.newspage.data.network.model.RemoteArticle
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface NewsArticleService {
    @GET("v2/everything")
    suspend fun getNewsArticles(@QueryMap params: Map<String, String>):Response<RemoteArticle>
}