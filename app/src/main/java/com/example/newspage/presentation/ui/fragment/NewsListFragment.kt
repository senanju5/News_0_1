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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newspage.R
import com.example.newspage.adapter.NewsListAdapter
import com.example.newspage.data.model.Article
import com.example.newspage.databinding.FragmentNewsListBinding
import com.example.newspage.presentation.MainViewModel
import com.example.newspage.utils.Utils
import com.example.newspage.utils.Utils.Companion.getQuery
import kotlinx.coroutines.launch


/**
 * A simple [Fragment] subclass.
 * Use the [NewsListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsListFragment : Fragment() {
  private lateinit var binding: FragmentNewsListBinding
   private val newsViewModel by activityViewModels<MainViewModel>()
    private lateinit var newsAdapter:NewsListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsListBinding.inflate(inflater, container, false)
        newsViewModel.getNews(getQuery())
        setUpRecyclerView()
        return binding.root
    }

    init {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                newsViewModel.articleList.collect {
                    it.articles?.let { it1 -> newsAdapter.submitData(it1) }

                }
            }
        }
    }

    fun setUpRecyclerView() {
        binding.articleListView.layoutManager = LinearLayoutManager(requireContext())
        newsAdapter = NewsListAdapter { article: Article, i: Int ->
            findNavController().navigate(R.id.action_newsListFragment_to_newsDetailFragment)
        }
        val decoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        binding.articleListView.addItemDecoration(decoration)
        binding.articleListView.adapter = newsAdapter
    }



}