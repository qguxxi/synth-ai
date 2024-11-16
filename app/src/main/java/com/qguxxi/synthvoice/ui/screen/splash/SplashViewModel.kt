package com.qguxxi.synthvoice.ui.screen.splash

import android.content.pm.PackageManager
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {
    private val _isGranted = mutableStateOf<Boolean>(false)

    val isGranted: MutableState<Boolean>
        get() = _isGranted

}