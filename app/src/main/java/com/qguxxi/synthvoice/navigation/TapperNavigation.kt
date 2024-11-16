package com.qguxxi.synthvoice.navigation

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qguxxi.synthvoice.ui.screen.home.HomeScreen
import com.qguxxi.synthvoice.ui.screen.permission.AudioRecordScreen
import com.qguxxi.synthvoice.ui.screen.permission.CameraPerScreen
import com.qguxxi.synthvoice.ui.screen.permission.NotificationPerScreen
import com.qguxxi.synthvoice.ui.screen.permission.PreHomeScreen
import com.qguxxi.synthvoice.ui.screen.permission.ReadExternalScreen
import com.qguxxi.synthvoice.ui.screen.signin.SignInScreen


enum class Screen {
    HOME,
    SIGNIN,
    PREHOME,
    CAMERAPER,
    NOTIFICATION,
    READEXTERNAL,
    AUDIORECORD,
}

@Composable
fun TapperNavHost(
    activity: Activity,
    navController: NavHostController = rememberNavController(),
    context : Context
) {
    NavHost(navController = navController, startDestination = Screen.SIGNIN.name) {
        composable(route = Screen.SIGNIN.name) {
            SignInScreen(navController,context)
        }
        composable(route = Screen.HOME.name) {
            HomeScreen()
        }
        composable(route = Screen.READEXTERNAL.name) {
            ReadExternalScreen(navController, activity)
        }
        composable(route = Screen.AUDIORECORD.name) {
            AudioRecordScreen(navController = navController, activity = activity, modifier = Modifier)
        }
        composable(route = Screen.PREHOME.name) {
            PreHomeScreen(navController = navController)
        }
        composable(route = Screen.CAMERAPER.name) {
            CameraPerScreen(navController, activity)
        }
        composable(route = Screen.NOTIFICATION.name) {
            NotificationPerScreen(activity,navController = navController)
        }
    }
}
