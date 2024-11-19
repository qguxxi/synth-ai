package com.qguxxi.synthvoice.ui.screen.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PermissionViewModel(

) : ViewModel() {
    private val _permissionGranted = MutableStateFlow(false)
    val permissionGranted: StateFlow<Boolean> = _permissionGranted

    fun checkPermission(hasPermission: Boolean) {
        viewModelScope.launch {
            _permissionGranted.value = hasPermission
        }
    }
}