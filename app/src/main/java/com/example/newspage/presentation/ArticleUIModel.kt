package com.example.newspage.presentation

import androidx.paging.PagingData
import com.example.newspage.data.model.Article

data class ArticleUIModel(val isLoading: Boolean, val articles: PagingData<Article>?)
