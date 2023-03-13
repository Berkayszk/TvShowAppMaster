package com.example.tvshowappmaster.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tvshowappmaster.R
import com.example.tvshowappmaster.databinding.FragmentTvShowBinding
import com.example.tvshowappmaster.databinding.FragmentTvShowDetailsBinding
import com.example.tvshowappmaster.model.PeopleResponseItem
import com.example.tvshowappmaster.model.TvShowResponseItem

class TvShowDetailsFragment : Fragment(R.layout.fragment_tv_show_details) {

    private var _binding: FragmentTvShowDetailsBinding? = null
    private val binding get() = _binding!!
    private val args : TvShowDetailsFragmentArgs by navArgs()
    private lateinit var tvshow : TvShowResponseItem
    private lateinit var people : PeopleResponseItem


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTvShowDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvshow = args.tvshow
        people = args.peopleshow

        populateUI()
    }
    private fun populateUI(){
        binding.apply {
            tvshowText.text = tvshow.name
            genresText.text = tvshow.genres.toString()
            languageText.text = tvshow.language
            ratingText.text = tvshow.rating.average.toString()
            runtimeText.text = tvshow.runtime.toString()
            statusText.text = tvshow.status

            binding.button.setOnClickListener {
                val direction = TvShowDetailsFragmentDirections.actionTvShowDetailsFragmentToTvShowWebView()
                it.findNavController().navigate(direction)
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}