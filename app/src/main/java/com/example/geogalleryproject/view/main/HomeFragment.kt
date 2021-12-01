package com.example.geogalleryproject.view.main

import android.content.Intent
import android.os.Bundle

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider

import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment

import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.geogalleryproject.R
import com.example.geogalleryproject.adapterimport.HomeFragmentAdapter
import com.example.geogalleryproject.databinding.FragmentHomeBinding
import com.example.geogalleryproject.model.photo.GeoGalleryModel
import com.example.geogalleryproject.model.photo.Photo

private const val TAG = "HomeFragment"
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private var photoList = listOf<Photo>()
    private val geoGalleryViewModel: HomeViewModel by activityViewModels()
    private lateinit var homeFragmentAdapter: HomeFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observers()

        homeFragmentAdapter = HomeFragmentAdapter(geoGalleryViewModel, requireActivity(),requireActivity().supportFragmentManager)
        binding.homeRecyclerView.adapter= homeFragmentAdapter
        geoGalleryViewModel.callPhoto()


    }

    fun observers(){
        geoGalleryViewModel.photoLiveData.observe(viewLifecycleOwner,{
            binding.homeProgressBar.animate().alpha(0f).duration=1000
            homeFragmentAdapter.subList(photoList)
            photoList = it.photos.photo
            binding.homeRecyclerView.animate().alpha(1f)
        })

        geoGalleryViewModel.photoErrorLiveData.observe(viewLifecycleOwner,{
            it?.let{
                Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show()
                Log.d(TAG,it)
                geoGalleryViewModel.photoErrorLiveData.postValue(null)

            }
        })

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.actionbarmenu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.app_bar_search -> {
                Toast.makeText(requireContext(), "Search", Toast.LENGTH_SHORT).show()
            }

            R.id.app_bar_location -> {
                val intent = Intent(activity, MapsActivity::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }


}
