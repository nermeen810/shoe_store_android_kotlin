package com.nermeen.shoe_store.viewModel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nermeen.shoe_store.model.ModelRepo
import com.nermeen.shoe_store.model.Shoe
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

 @HiltViewModel
class MainViewModel @Inject constructor(private val modelRepository: ModelRepo) : ViewModel() {
     companion object {
         var _addShoe = MutableLiveData<ArrayList<Shoe>>(arrayListOf())
     }

     fun isLogin():Boolean{
       return modelRepository.isLogin()
     }

     fun setLogin(email:Boolean){
         modelRepository.setLogin(email)
     }

     fun setEmail(email:String){
            modelRepository.setEmail(email)
     }

     fun getEmail():String{
         return modelRepository.getEmail()
     }

}