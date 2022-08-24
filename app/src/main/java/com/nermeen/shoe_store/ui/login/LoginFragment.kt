package com.nermeen.shoe_store.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nermeen.shoe_store.R
import com.nermeen.shoe_store.databinding.FragmentInstructionBinding
import com.nermeen.shoe_store.databinding.FragmentLoginBinding
import com.nermeen.shoe_store.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
   private val viewModel: MainViewModel by viewModels()
   private lateinit var binding: FragmentLoginBinding
    private var email = ""
    private var pass = ""
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
        binding.loginButton.setOnClickListener {
            email = binding.editTextEmail.text.toString()
            pass = binding.editTextPassword.text.toString()
            validateData()
        }
    }
    private fun validateData() {
        validateEmail()
        validatPassword()
        if (validateEmail() && validatPassword()) {
          login()
        }
    }

    private fun login() {
        Toast.makeText(
            requireActivity(),
            getString(R.string.success_login),
            Toast.LENGTH_SHORT
        ).show()
        viewModel.setEmail(email)
        viewModel.setLogin(true)
        navigateToWelcome()
    }

    private fun navigateToWelcome() {
        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
        findNavController().navigate(action)
    }

    private fun validateEmail(): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
        return if (email.isEmpty()) {
            binding.textInputEmail.error = getString(R.string.required_field)
            false
        }
        else if (!email.matches(emailPattern)) {
            binding.textInputEmail.error = getString(R.string.invalid_email)
            false
        }
        else {
            binding.textInputEmail.error = null
            binding.textInputEmail.isErrorEnabled = false
            true
        }
    }

    private fun validatPassword(): Boolean {
        return if (pass.isEmpty()) {
            binding.textInputPassword.error = getString(R.string.required_field)
            false
        }
        else {
            binding.textInputPassword.error = null
            binding.textInputPassword.isErrorEnabled = false
            true
        }
    }
}