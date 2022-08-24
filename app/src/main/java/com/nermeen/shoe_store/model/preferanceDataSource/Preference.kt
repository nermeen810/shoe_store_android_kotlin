package com.nermeen.shoe_store.model.preferanceDataSource

interface Preference {
    fun isLogin():Boolean
    fun setLogin(login:Boolean)
    fun setEmail(email:String)
    fun getEmail():String
    fun logout()
}