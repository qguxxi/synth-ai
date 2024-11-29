package com.qguxxi.synthvoice.ui.screen.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.qguxxi.synthvoice.data.source.local.UserSharePreference
import com.qguxxi.synthvoice.untils.PermissionPreferences

class SignInViewModel(
    private val permissionPreferences : PermissionPreferences ,
    private val userPreferences: UserSharePreference
) : ViewModel() {

    private val _permissionStatus = MutableLiveData<Boolean>()
    val permissionStatus : LiveData<Boolean> get() = _permissionStatus


    fun checkPermissionStatus() {
        _permissionStatus.value = permissionPreferences.hasPermission()
    }

    fun setPermissionGranted() {
        permissionPreferences.setPermissionGranted()
    }

    fun saveLoginToken(token: String) {
        userPreferences.saveTokenUser(token)
    }

    fun isLoggedIn(): Boolean {
        return userPreferences.isLoggedIn()
    }

    fun logout() {
        userPreferences.clearLoginInfo()
    }

}