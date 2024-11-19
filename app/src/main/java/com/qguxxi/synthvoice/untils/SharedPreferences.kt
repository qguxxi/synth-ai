package com.qguxxi.synthvoice.untils

import android.content.Context
import android.content.SharedPreferences

class PermissionPreferences(context: Context) {
    private val permissionPreferences : SharedPreferences = context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)

    fun hasPermission(): Boolean {
        return permissionPreferences.getBoolean("has_permission", false)
    }

    fun setPermissionGranted() {
        permissionPreferences.edit().putBoolean("has_permission", true).apply()
    }
}

class SignInPreferences(context : Context) {
    private val signInPreferences : SharedPreferences = context.getSharedPreferences("sign_in_preferences",Context.MODE_PRIVATE)
    fun hasSignIn(): Boolean {
        return signInPreferences.getBoolean("has_permission", false)
    }

    fun setSignIn() {
        signInPreferences.edit().putBoolean("has_permission", true).apply()
    }

}