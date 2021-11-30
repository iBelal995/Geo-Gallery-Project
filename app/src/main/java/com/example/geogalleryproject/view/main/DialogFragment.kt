package com.example.geogalleryproject.view.main

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.geogalleryproject.R

class DialogFragment : DialogFragment () {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setView(R.layout.fragment_dialog)
            .create()
  }