package com.qguxxi.synthvoice.navigation

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qguxxi.synthvoice.data.source.local.UserSharePreference
import com.qguxxi.synthvoice.ui.screen.SettingScreen
import com.qguxxi.synthvoice.ui.screen.home.HomeScreen
import com.qguxxi.synthvoice.ui.screen.permission.AudioRecordScreen
import com.qguxxi.synthvoice.ui.screen.permission.CameraPerScreen
import com.qguxxi.synthvoice.ui.screen.permission.NotificationPerScreen
import com.qguxxi.synthvoice.ui.screen.permission.PreHomeScreen
import com.qguxxi.synthvoice.ui.screen.permission.ReadExternalScreen
import com.qguxxi.synthvoice.ui.screen.signin.SignInScreen
import com.qguxxi.synthvoice.ui.screen.signin.SignInViewModel
import com.qguxxi.synthvoice.untils.PermissionPreferences


enum class Screen {
    HOME,
    SIGNIN,
    PREHOME,
    CAMERAPER,
    NOTIFICATION,
    READEXTERNAL,
    AUDIORECORD,
    SETTING
}

@Composable
fun TapperNavHost(
    activity: Activity,
    navController: NavHostController = rememberNavController(),
    context : Context
) {
    NavHost(navController = navController, startDestination = Screen.SIGNIN.name) {
        composable(route = Screen.SIGNIN.name) {
            SignInScreen(
                navController,
                signInViewModel = SignInViewModel(permissionPreferences = PermissionPreferences(context),
                userPreferences = UserSharePreference(context)
                    )
            )
        }
        composable(route = Screen.HOME.name) {
            HomeScreen(context = context, navController)
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
        composable(route = Screen.SETTING.name) {
            SettingScreen(navController)
        }
    }
}

