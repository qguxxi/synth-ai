package com.qguxxi.synthvoice.untils.permission

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.view.ContextMenu
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.qguxxi.synthvoice.navigation.Screen

val requiredPermissions = arrayOf(
    Manifest.permission.CAMERA,
    Manifest.permission.READ_EXTERNAL_STORAGE,
    Manifest.permission.ACCESS_FINE_LOCATION
)

fun checkPermission(context : Context, permissions: Array<String>) : Boolean  {
    return permissions.all { permission ->
        ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED }
}