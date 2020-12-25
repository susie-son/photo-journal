package com.susieson.food.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.susieson.food.R
import com.susieson.food.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val entryAdapter = EntryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.recyclerView.apply {
            adapter = entryAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.entries?.observe(viewLifecycleOwner) {
            entryAdapter.submitList(it)
        }
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPictureFragment())
        }
        return binding.root
    }
}