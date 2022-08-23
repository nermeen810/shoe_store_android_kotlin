package com.nermeen.shoe_store.model.preferanceDataSource

interface Preference {
    fun getFirstTimeLaunch():Boolean
    fun setFirstTimeLaunch(firstTimeLaunch:Boolean)
    fun isLogin():Boolean
    fun setLogin(login:Boolean)
    fun setToken(token:String)
    fun getToken():String
    fun setRefreshToken(refreshToken:String)
    fun getRefreshToken():String
    fun logout()
}