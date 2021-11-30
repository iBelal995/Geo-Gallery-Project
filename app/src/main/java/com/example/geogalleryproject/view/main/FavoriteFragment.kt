package com.example.geogalleryproject.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import com.example.geogalleryproject.R
import com.example.geogalleryproject.databinding.FragmentFavoriteBinding
import com.example.geogalleryproject.databinding.FragmentHomeBinding
import com.example.geogalleryproject.view.FavoriteViewModel
import com.example.geogalleryproject.view.adapters.FavoriteRecyclerViewAdapter
import kotlinx.coroutines.Dispatchers

class FavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by activityViewModels()
    private lateinit var favoriteRecyclerAdapter: FavoriteRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



    fun observers(){

//if (){
//
//}

    }


    }

