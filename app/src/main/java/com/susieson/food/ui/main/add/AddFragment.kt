package com.susieson.food.ui.main.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.susieson.food.R
import com.susieson.food.databinding.FragmentAddBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private val viewModel: AddViewModel by viewModels()
    private val args: AddFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false)
        viewModel.imageUrl = args.downloadUrl ?: ""
        binding.imagePreview.load(viewModel.imageUrl)
        binding.descriptionInput.addTextChangedListener {
            it?.let { viewModel.setDescription(it.toString()) }
        }
        binding.submitButton.setOnClickListener {
            viewModel.addEntry()
            findNavController().popBackStack(R.id.homeFragment, false)
        }
        return binding.root
    }
}