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
import com.susieson.food.R
import com.susieson.food.databinding.FragmentAddBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private val viewModel: AddViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false)
        binding.nameInput.addTextChangedListener {
            it?.let { viewModel.setName(it.toString()) }
        }
        viewModel.isNameValid.observe(viewLifecycleOwner) {
            binding.nameInputLayout.error = if (it) null else getString(R.string.name_input_error)
        }
        viewModel.areEntriesValid.observe(viewLifecycleOwner) {
            binding.submitButton.isEnabled = it
        }
        binding.submitButton.setOnClickListener {
            viewModel.addEntry()
            findNavController().navigateUp()
        }
        return binding.root
    }
}