package com.tes.magnakarga.tesmagnakarsafe.app

import android.content.Context
import android.content.SharedPreferences
import com.tes.magnakarga.tesmagnakarsafe.R

class AppPreference(val context: Context) {

    private val pref : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor
    private val PRIVATE_MODE : Int = 0

    private val USERNAME = "USERNAME"
    private val LOGIN_STATE = "LOGIN_STATE"

    init {
        pref = context.getSharedPreferences(context.resources.getString(R.string.app_name), PRIVATE_MODE)
    }

    fun setUserName(username : String?) {
        editor = pref.edit()
        editor.putString(USERNAME, username)
        editor.apply()
    }

    fun getUsername() : String? = pref.getString(USERNAME, "")

    fun setLoginState(loginState : String?) {
        editor = pref.edit()
        editor.putString(LOGIN_STATE, loginState)
        editor.apply()
    }
    fun getLoginState() : String? = pref.getString(LOGIN_STATE, "")
}