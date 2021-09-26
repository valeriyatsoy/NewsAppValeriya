package com.example.android.newsappvaleriya.ui.newsDetail

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.newsappvaleriya.databinding.FragmentNewsDetailBinding
import java.net.URL

class NewsDetailFragment : Fragment() {

    companion object {
        const val KEY_ARTICLE_URL = "article_url"
        fun newInstance(articleUrl: URL): NewsDetailFragment {
            val f = NewsDetailFragment()
            val args = Bundle()
            args.putSerializable(
                KEY_ARTICLE_URL,
                articleUrl
            )
            f.arguments = args
            return f
        }
    }

    private val articleUrl: URL by lazy {
        requireArguments().getSerializable(KEY_ARTICLE_URL) as URL
    }

    private var _binding: FragmentNewsDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        articleUrl.let { loadUrl(it) }
    }

    private fun loadUrl(url: URL) {
        binding.detailWebview.apply {
            settings.javaScriptEnabled = true
            setBackgroundColor(Color.TRANSPARENT);

            loadUrl(url.toString());
        }
    }

}