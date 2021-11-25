package com.example.geogalleryproject.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geogalleryproject.R
import com.example.geogalleryproject.databinding.FragmentFavoriteBinding
import com.example.geogalleryproject.databinding.FragmentHomeBinding

class FavoriteFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

}