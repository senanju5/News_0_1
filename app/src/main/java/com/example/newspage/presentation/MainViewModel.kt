package com.example.newspage.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newspage.data.model.Article
import com.example.newspage.data.repository.NewsRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: NewsRepository = NewsRepository()): ViewModel() {
    //private val newsLiveData = MutableLiveData<List<Article>>()
    private val articleMutableSate by lazy {MutableStateFlow(ArticleUIModel(true, null))  }
    internal val articleList : StateFlow<ArticleUIModel> = articleMutableSate

   fun getNews(queryMap: Map<String, String>) {
        viewModelScope.launch {
            repository.getNewsArticles(queryMap).collect{
                    articleMutableSate.value = ArticleUIModel(false, it)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}