package com.qguxxi.synthvoice

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import com.qguxxi.synthvoice.navigation.TapperNavHost

@Composable
fun TapperApp(activity: Activity, context : Context) {
    TapperNavHost(activity = activity, context = context)
}