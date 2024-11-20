package com.qguxxi.synthvoice.ui.screen.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qguxxi.synthvoice.untils.PermissionPreferences
import com.qguxxi.synthvoice.untils.SignInPreferences
import kotlinx.coroutines.launch

class SignInViewModel(
    private val permissionPreferences: PermissionPreferences,
    ) : ViewModel() {

    private val _permissionStatus = MutableLiveData<Boolean>()
    val permissionStatus: LiveData<Boolean> get() = _permissionStatus


    fun checkPermissionStatus() {
        _permissionStatus.value = permissionPreferences.hasPermission()
    }

    fun setPermissionGranted() {
        permissionPreferences.setPermissionGranted()
    }

}