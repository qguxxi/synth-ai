package com.qguxxi.synthvoice.ui.screen.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.qguxxi.synthvoice.untils.PermissionPreferences

class SignInViewModel(
    private val permissionPreferences : PermissionPreferences ,
) : ViewModel() {

    private val _permissionStatus = MutableLiveData<Boolean>()
    val permissionStatus : LiveData<Boolean> get() = _permissionStatus


    fun checkPermissionStatus() {
        _permissionStatus.value = permissionPreferences.hasPermission()
    }

    fun setPermissionGranted() {
        permissionPreferences.setPermissionGranted()
    }

}