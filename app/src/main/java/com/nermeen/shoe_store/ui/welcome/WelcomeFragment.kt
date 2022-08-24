package com.nermeen.shoe_store.ui.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nermeen.shoe_store.R
import com.nermeen.shoe_store.databinding.FragmentShoeListBinding
import com.nermeen.shoe_store.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
private lateinit var binding: FragmentWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {

    }


}