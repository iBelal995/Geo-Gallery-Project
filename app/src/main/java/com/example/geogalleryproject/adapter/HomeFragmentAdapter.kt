package com.example.geogalleryproject.adapterimport

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.example.geogalleryproject.databinding.HomeItemLayoutBinding
import com.example.geogalleryproject.model.photo.Photo
import com.example.geogalleryproject.view.main.HomeViewModel

class HomeFragmentAdapter(val viewModel: HomeViewModel, val context: Context) :
    RecyclerView.Adapter<HomeFragmentAdapter.MainViewHolder>() {

    val DIFF_CALL_BACK = object : DiffUtil.ItemCallback<Photo>(){
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this,DIFF_CALL_BACK)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeFragmentAdapter.MainViewHolder {

        val binding= HomeItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
    fun subList(list: List<Photo>){
        differ.submitList(list)
    }
    inner class MainViewHolder(val binding: HomeItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Photo){
            Glide.with(context).load(item.urlM).into(binding.homeImageView)
        }
    }
}