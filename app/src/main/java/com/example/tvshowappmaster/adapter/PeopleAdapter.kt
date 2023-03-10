package com.example.tvshowappmaster.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.tvshowappmaster.databinding.TvshowRowBinding
import com.example.tvshowappmaster.model.PeopleResponseItem
import com.example.tvshowappmaster.view.TvShowDetailsFragmentDirections

class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    inner class PeopleViewHolder(val binding : TvshowRowBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<PeopleResponseItem>(){
        override fun areItemsTheSame(
            oldItem: PeopleResponseItem,
            newItem: PeopleResponseItem
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PeopleResponseItem,
            newItem: PeopleResponseItem
        ): Boolean {
            return oldItem==newItem
        }

    }
    private val differ  = AsyncListDiffer(this,diffCallBack)
    var people : List<PeopleResponseItem>
    get() = differ.currentList
    set(value) {
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        return PeopleViewHolder(TvshowRowBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return people.size
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val currentPeople = people[position]
        holder.binding.apply {
            textView.text = currentPeople.name
            imageView.load(currentPeople.image.original){
                crossfade(true)
                crossfade(1000)
            }
        }
        holder.itemView.setOnClickListener {
            val direction = TvShowDetailsFragmentDirections.actionTvShowDetailsFragmentToTvShowWebView()
            it.findNavController().navigate(direction)
        }
    }



}