package com.nermeen.shoe_store.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nermeen.shoe_store.R
import com.nermeen.shoe_store.databinding.FragmentInstructionBinding
import com.nermeen.shoe_store.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {

    }

}