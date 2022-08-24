package com.nermeen.shoe_store.ui.shoeList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.nermeen.shoe_store.R
import com.nermeen.shoe_store.databinding.FragmentLoginBinding
import com.nermeen.shoe_store.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {

private  lateinit var binding: FragmentShoeListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        init()
        return binding.root
    }

    private fun init() {

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}