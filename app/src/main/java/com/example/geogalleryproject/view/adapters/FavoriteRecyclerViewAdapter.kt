package com.example.geogalleryproject.view.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.example.geogalleryproject.R
import com.example.geogalleryproject.database.GeoGalleryDao
import com.example.geogalleryproject.databinding.FavoriteItemLayoutBinding
import com.example.geogalleryproject.model.Photo
import com.example.geogalleryproject.model.Photos
import com.example.geogalleryproject.view.FavoriteViewModel

class FavoriteRecyclerViewAdapter( val list: List<FavoriteViewModel>, val favoriteViewModel: FavoriteViewModel) :
    RecyclerView.Adapter<FavoriteRecyclerViewAdapter.FavoriteViewHolder>() {



    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Photo>(){

        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            // Its nessccerly id it could be any thing unique like username
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem        }
    }

    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    fun submitList(list: List<Photo>){
        differ.submitList(list)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int

    ): FavoriteRecyclerViewAdapter.FavoriteViewHolder {

 val binding = FavoriteItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding,favoriteViewModel)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = differ.currentList[position]
        // in every projects its the same
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    class FavoriteViewHolder(val binding: FavoriteItemLayoutBinding,val favoriteViewModel: FavoriteViewModel) : RecyclerView.ViewHolder(binding.root) {
        // it will take every product and save inside the every item
        fun bind(item: Photo){

            binding.favoriteToggleButton.setOnClickListener {
                if (binding.favoriteToggleButton.isChecked) {
                    
                }else{

                }
            }

        }

    }
}