package com.qguxxi.synthvoice.data.source.local

import android.content.Context
import android.content.SharedPreferences

class UserSharePreference(context : Context) {
    val userSharePreference: SharedPreferences = context.getSharedPreferences("user_prefs",Context.MODE_PRIVATE)

    fun saveTokenUser(token: String) {
        userSharePreference.edit().putString("token",token).apply()
    }
    fun getLoginInfo(): String? {
        return userSharePreference.getString("token", null)
    }

    fun clearLoginInfo() {
        userSharePreference.edit()
            .remove("token")
            .apply()
    }

    fun isLoggedIn(): Boolean {
        return getLoginInfo() != null
    }
}