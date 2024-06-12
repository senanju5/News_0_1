package com.example.newspage.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newspage.data.network.model.Article
import com.example.newspage.data.remotedata.RemoteDataSource

class ArticlePagingSource(
    private val remoteDataSource: RemoteDataSource,
    private val query: HashMap<String, String>,
) :
    PagingSource<Int, Article>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
       return try {
            val nextPage = params.key ?: 1
            query["page"] = nextPage.toString()
            val response = remoteDataSource.getRemoteData(query)
            if (response.isSuccessful) {
                LoadResult.Page(data = response.body()?.articles?: emptyList(),
                    prevKey = if (nextPage == 1) null else nextPage - 1,
                    nextKey = nextPage + 1)
            } else {
                LoadResult.Error(throw Exception("No Response"))
            }

        } catch (e: Exception) {
            LoadResult.Error(e)

        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition.let {
            state.closestPageToPosition(it ?: return null)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

}