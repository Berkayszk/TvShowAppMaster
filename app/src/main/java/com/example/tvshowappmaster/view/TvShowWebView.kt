package com.example.tvshowappmaster.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.webkit.WebViewFragment
import androidx.navigation.fragment.navArgs
import com.example.tvshowappmaster.R
import com.example.tvshowappmaster.databinding.FragmentTvShowWebViewBinding
import com.example.tvshowappmaster.model.TvShowResponseItem

class TvShowWebView : Fragment(R.layout.fragment_tv_show_web_view) {

    private var _binding : FragmentTvShowWebViewBinding?=null
    val binding get() = _binding!!
    private lateinit var tvshow : TvShowResponseItem
    private val args : TvShowWebViewArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTvShowWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvshow = args.tvshow
        setUpWebView()

    }
    private fun setUpWebView(){
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(tvshow.url)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}