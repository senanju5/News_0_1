package com.example.newspage.data.network.model


import com.example.newspage.data.network.model.Article
import com.google.gson.annotations.SerializedName

data class RemoteArticle(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String, // ok
    @SerializedName("totalResults")
    val totalResults: Int // 10043
)