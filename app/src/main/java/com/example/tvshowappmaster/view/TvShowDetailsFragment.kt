package com.example.tvshowappmaster.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tvshowappmaster.R
import com.example.tvshowappmaster.databinding.FragmentTvShowBinding
import com.example.tvshowappmaster.databinding.FragmentTvShowDetailsBinding

class TvShowDetailsFragment : Fragment(R.layout.fragment_tv_show_details) {

    private var _binding: FragmentTvShowDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTvShowDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}