package com.qguxxi.synthvoice.ui.screen.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.qguxxi.synthvoice.untils.PermissionPreferences
import com.qguxxi.synthvoice.untils.SignInPreferences

class SignInViewModel(private val permissionPreferences: PermissionPreferences,private val signInPreferences : SignInPreferences) : ViewModel() {

    private val _permissionStatus = MutableLiveData<Boolean>()
    val permissionStatus: LiveData<Boolean> get() = _permissionStatus


    private val _signInStatus = MutableLiveData<Boolean>()
    val signInStatus: LiveData<Boolean> get() = _permissionStatus

    fun checkPermissionStatus() {
        _permissionStatus.value = permissionPreferences.hasPermission()
    }

    fun setPermissionGranted() {
        permissionPreferences.setPermissionGranted()
    }

    fun checkSignInStatus() {
        _signInStatus.value = signInPreferences.hasSignIn()
    }


    fun setSignInGranted() {
        signInPreferences.setSignIn()
    }
}