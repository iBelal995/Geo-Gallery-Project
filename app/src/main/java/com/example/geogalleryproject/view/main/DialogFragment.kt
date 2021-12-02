package com.example.geogalleryproject.view.main

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.geogalleryproject.R
import com.example.geogalleryproject.databinding.FragmentDialogBinding

class DialogFragment : DialogFragment () {

      private lateinit var binding: FragmentDialogBinding
      override fun onCreateView(
          inflater: LayoutInflater, container: ViewGroup?,
          savedInstanceState: Bundle?
      ): View? {
          binding = FragmentDialogBinding.inflate(inflater, container, false)
          // Inflate the layout for this fragment
          return binding.root

      }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addFav.setOnClickListener {
            Toast.makeText(context, "hi", Toast.LENGTH_SHORT).show()
        }

    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setView(R.layout.fragment_dialog)
            .create()



  }