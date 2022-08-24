package com.nermeen.shoe_store.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nermeen.shoe_store.R
import com.nermeen.shoe_store.databinding.FragmentDetailsBinding
import com.nermeen.shoe_store.model.Shoe
import com.nermeen.shoe_store.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private  lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        binding.saveButton.setOnClickListener {
            validateData()
        }
    }

    private fun validateData() {
        val isValidName = validateName()
        val isValidCompany = validateCompany()
        val isValidSize = validateSize()
        val isValidDescription = validateDescription()
        if(isValidName && isValidCompany && isValidSize && isValidDescription){
            val name = binding.editTextName.text.toString()
            val company = binding.editTextCompany.text.toString()
            val size = binding.editTextSize.text.toString()
            val des = binding.editTextDescription.text.toString()

            MainViewModel._addShoe.value?.add(Shoe(name, company, size, des))
            findNavController().popBackStack()
        }
    }

    private fun validateDescription(): Boolean {
          val des = binding.editTextDescription.text.toString()
            return if (des.isEmpty()) {
                binding.textInputName.error = getString(R.string.required_field)
                false
            }
            else {
                binding.textInputName.error = null
                binding.textInputName.isErrorEnabled = false
                true
            }
        }

    private fun validateSize(): Boolean {
        val size = binding.editTextSize.text.toString()
        return if (size.isEmpty()) {
            binding.textInputName.error = getString(R.string.required_field)
            false
        }
        else {
            binding.textInputName.error = null
            binding.textInputName.isErrorEnabled = false
            true
        }
    }


    private fun validateCompany(): Boolean {
        val company = binding.editTextCompany.text.toString()
        return if (company.isEmpty()) {
            binding.textInputName.error = getString(R.string.required_field)
            false
        }
        else {
            binding.textInputName.error = null
            binding.textInputName.isErrorEnabled = false
            true
        }
    }


    private fun validateName(): Boolean {
        val name = binding.editTextName.text.toString()
        return if (name.isEmpty()) {
            binding.textInputName.error = getString(R.string.required_field)
            false
        }
        else {
            binding.textInputName.error = null
            binding.textInputName.isErrorEnabled = false
            true
        }
    }
    }

