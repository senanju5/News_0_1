package com.example.newspage.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.newspage.R
import com.example.newspage.databinding.FragmentNewsListBinding
import com.example.newspage.presentation.MainViewModel
import com.example.newspage.utils.Utils
import kotlinx.coroutines.launch


/**
 * A simple [Fragment] subclass.
 * Use the [NewsListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsListFragment : Fragment() {
  private lateinit var binding: FragmentNewsListBinding
   private val newsViewModel by activityViewModels<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsListBinding.inflate(inflater, container, false)
        newsViewModel.getNews(getQuery())
        return binding.root
    }

    init {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                newsViewModel.articleList.collect {
                    Log.d("NewsListFragment", "articleList: $it")
                }
            }
        }
    }

    fun getQuery():Map<String,String> {
        val query = HashMap<String, String>()
        query["q"] = "tesla"
        query["from"] = "2022-11-11"
        query["sortBy"] = "publishedAt"
        query[ "apiKey"] = Utils.API_KEY
        query["pageSize"] = "1"
        return query
    }

}