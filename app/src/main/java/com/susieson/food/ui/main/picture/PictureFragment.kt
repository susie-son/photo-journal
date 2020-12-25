package com.susieson.food.ui.main.picture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.susieson.food.R
import com.susieson.food.databinding.FragmentPictureBinding

class PictureFragment : Fragment() {
    private lateinit var binding: FragmentPictureBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_picture, container, false)
        return binding.root
    }
}