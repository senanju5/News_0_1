package com.example.newspage.data.network.model


import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("author")
    val author: String, // Tom Carter
    @SerializedName("content")
    val content: String, // A $35,000 version of the Chevy Equinox will be available later this year. Chevrolet<ul><li>US customers want more affordable EVs. </li><li>They might soon get their wish, with a host of cheaper ele… [+4278 chars]
    @SerializedName("description")
    val description: String, // Demand for electric vehicles has slowed amid a lack of cheaper options, and carmakers are now scrambling to get more affordable EVs on the road.
    @SerializedName("publishedAt")
    val publishedAt: String, // 2024-06-09T13:55:01Z
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String, // EVs are too expensive. Here are 5 cheaper models coming soon.
    @SerializedName("url")
    val url: String, // https://www.businessinsider.com/evs-too-expensive-5-upcoming-affordable-models-kia-chevy-volvo-2024-6
    @SerializedName("urlToImage")
    val urlToImage: String // https://i.insider.com/665dc2ce1cd3b17790426b84?width=1200&format=jpeg
)