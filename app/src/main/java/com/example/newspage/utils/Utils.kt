package com.example.newspage.utils

class Utils {
    companion object {
        val BASE_URL = "https://newsapi.org"
        private val API_KEY  = "0802a4828e9a4980badc69cb35a2110d"

        fun getQuery():HashMap<String,String> {
            val query = HashMap<String, String>()
            query["q"] = "tesla"
            query["from"] = "2024-05-12"
            query["sortBy"] = "publishedAt"
            query[ "apiKey"] = API_KEY
            query["page"] = "1"
            return query
        }
    }
}