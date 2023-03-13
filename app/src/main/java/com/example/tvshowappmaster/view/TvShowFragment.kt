package com.example.tvshowappmaster.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tvshowappmaster.R
import com.example.tvshowappmaster.adapter.PeopleAdapter
import com.example.tvshowappmaster.adapter.TvShowAdapter
import com.example.tvshowappmaster.databinding.FragmentTvShowBinding
import com.example.tvshowappmaster.viewmodel.TvShowViewModel
import javax.inject.Inject

class TvShowFragment @Inject constructor(
    private var tvShowAdapter : TvShowAdapter,
    private var peopleAdapter : PeopleAdapter
) : Fragment(R.layout.fragment_tv_show) {

    private var _binding : FragmentTvShowBinding?=null
    private val binding get() = _binding!!
    private val viewModel : TvShowViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRvTvShow()
    }
    private fun setupRvTvShow(){
        tvShowAdapter = TvShowAdapter()

        binding.recyclerView.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)
        }
        binding.recyclerViewEpisode.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)
        }
        binding.recyclerViewPeople.apply {
            adapter = peopleAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
        viewModel.tvShowResponse.observe(requireActivity(), {response->
            tvShowAdapter.tvshow = response
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}