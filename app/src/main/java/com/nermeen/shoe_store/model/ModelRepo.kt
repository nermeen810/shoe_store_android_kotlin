package com.nermeen.shoe_store.model

import android.app.Application
import android.content.Context
import com.nermeen.shoe_store.model.preferanceDataSource.MySharedPreference
import com.nermeen.shoe_store.model.preferanceDataSource.Preference
import com.nermeen.shoe_store.utils.EMAIL_KEY
import com.nermeen.shoe_store.utils.LOGIN_KEY
import com.nermeen.shoe_store.utils.PREF_FILE_NAME
import javax.inject.Inject

class ModelRepo @Inject constructor( private val context: Application) :Preference{
    private val preference = MySharedPreference(
        context.getSharedPreferences(
            PREF_FILE_NAME,
            Context.MODE_PRIVATE
        )
    )
    override fun isLogin(): Boolean {
        return preference.getBoolean(LOGIN_KEY)
    }

    override fun setLogin(login: Boolean) {
        return preference.setBoolean(LOGIN_KEY,login)
    }

    override fun setEmail(email: String) {
        return preference.setString(EMAIL_KEY,email)
    }

    override fun getEmail(): String {
        return preference.getString(EMAIL_KEY)
    }

    override  fun logout() {
        setLogin(false)
        setEmail("")
    }


}