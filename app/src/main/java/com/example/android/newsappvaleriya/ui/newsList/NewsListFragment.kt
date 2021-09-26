package com.example.android.newsappvaleriya.ui.newsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.newsappvaleriya.databinding.FragmentNewsListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : Fragment() {

    companion object {
        fun newInstance() = NewsListFragment()
    }

    private lateinit var viewModel: NewsListViewModel
    private lateinit var newsAdapter: NewsAdapter

    private var _binding: FragmentNewsListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsListViewModel::class.java)
        setUpNewsList()
        initObservers()
    }

    private fun setUpNewsList() {
        newsAdapter = NewsAdapter()

        binding.newsRecycler.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = newsAdapter
        }
    }

    private fun initObservers (){
        viewModel.responseNews.observe(viewLifecycleOwner, { list ->
            newsAdapter.submitList(list)
        })
    }

}