package com.nermeen.shoe_store.ui.shoeList

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.nermeen.shoe_store.R
import com.nermeen.shoe_store.databinding.FragmentShoeListBinding
import com.nermeen.shoe_store.model.Shoe
import com.nermeen.shoe_store.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShoeListFragment : Fragment() {

   private  lateinit var binding: FragmentShoeListBinding

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
        binding.fab.setOnClickListener {
            val action = ShoeListFragmentDirections.actionShoeListFragmentToDetailsFragment()
            findNavController().navigate(action)
        }
        observeToShoeList()
    }

    private fun observeToShoeList() {
     val  it =  MainViewModel._addShoe.value
       Log.e("shoe",MainViewModel._addShoe.value.toString())
            it.let {
                if (it != null) {
                    for (item in it) {
                        Log.e("item",item.toString())

                        val params = RelativeLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        )
                        params.setMargins(16, 16, 16, 16)
                        val cardView = CardView(requireContext())
                        cardView.radius = 15f
                        cardView.setContentPadding(20, 20, 20, 20)
                        cardView.layoutParams = params
                        cardView.cardElevation = 30f
                        binding.layout.addView(addItem(cardView,item))
                    }
                }
            }
        }

    private fun addItem(cardView: CardView,item:Shoe):CardView {
        val params = RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(16, 16, 16, 16)
        val linearLayout = LinearLayout(requireContext())
        linearLayout.orientation = LinearLayout.VERTICAL

        linearLayout.layoutParams= params

        val name = TextView(requireContext())
        name.text = "Name           : ${item.name}"
        name.textSize = 18f
        name.setTextColor(Color.BLACK)
        name.setTypeface(Typeface.SANS_SERIF,Typeface.NORMAL)
        linearLayout.addView(name)

        val company = TextView(requireContext())
        company.text =  "Company     : ${item.company}"
        company.textSize = 18f
        company.setTextColor(Color.BLACK)
        company.setTypeface(Typeface.SANS_SERIF,Typeface.NORMAL)
        linearLayout.addView(company)

        val size = TextView(requireContext())
        size.text =  "Size              : ${item.size}"
        size.textSize = 18f
        size.setTextColor(Color.BLACK)
        size.setTypeface(Typeface.SANS_SERIF,Typeface.NORMAL)
        linearLayout.addView(size)


        val des = TextView(requireContext())
        des.text = "Description : ${item.description}"
        des.textSize = 18f
        des.setTextColor(Color.BLACK)
        des.setTypeface(Typeface.SANS_SERIF,Typeface.NORMAL)
        linearLayout.addView(des)
        cardView.addView(linearLayout)
     return cardView
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        navigateToLogin()
        return super.onOptionsItemSelected(item)
    }

    private fun navigateToLogin() {
        val action = ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment()
        findNavController().navigate(action)
    }
}