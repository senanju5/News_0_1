package com.example.newspage.data.network.model


import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    val id: String, // business-insider
    @SerializedName("name")
    val name: String // Business Insider
)