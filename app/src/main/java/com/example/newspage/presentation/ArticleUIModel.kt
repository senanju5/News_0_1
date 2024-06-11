package com.example.newspage.presentation

import com.example.newspage.data.model.Article

data class ArticleUIModel(val isLoading: Boolean, val articles: List<Article>?)
