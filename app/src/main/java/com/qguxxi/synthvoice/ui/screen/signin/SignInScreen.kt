package com.qguxxi.synthvoice.ui.screen.signin

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.qguxxi.synthvoice.BuildConfig
import com.qguxxi.synthvoice.R
import com.qguxxi.synthvoice.navigation.Screen
import com.qguxxi.synthvoice.ui.components.button.GoogleButton
import com.qguxxi.synthvoice.ui.components.under.PrivacyPolicy
import com.qguxxi.synthvoice.ui.theme.figmaTypography
import com.stevdzasan.onetap.OneTapSignInWithGoogle
import com.stevdzasan.onetap.rememberOneTapSignInState


@Composable
fun SignInScreen(
    navController : NavController ,
    signInViewModel : SignInViewModel ,
) {
    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(false) }
    val permissionStatus by signInViewModel.permissionStatus.observeAsState(false)
    val permissions = arrayOf(
        Manifest.permission.RECORD_AUDIO , // Quyền ghi âm
        Manifest.permission.CAMERA , // Quyền ghi âm
        Manifest.permission.POST_NOTIFICATIONS , // Quyền ghi âm
        Manifest.permission.READ_EXTERNAL_STORAGE , // Quyền ghi âm
    )
    // Kiểm tra quyền ngay khi khởi động
    LaunchedEffect(Unit) {
        if (signInViewModel.isLoggedIn()) {
            navController.navigate(Screen.HOME.name) {
                popUpTo(Screen.SIGNIN.name) { inclusive = true }
            }
        }
        if (permissions.all {
                ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
            }) {
            signInViewModel.setPermissionGranted()
        }
    }
    val state = rememberOneTapSignInState()

    val apiKey = BuildConfig.API_KEY


    OneTapSignInWithGoogle(
        state = state ,
        clientId = apiKey ,
        onTokenIdReceived = { tokenId ->
            signInViewModel.saveLoginToken(tokenId)
            signInViewModel.checkPermissionStatus()
            if (permissionStatus) {
                navController.navigate(Screen.HOME.name) {
                    popUpTo(Screen.SIGNIN.name) {
                        inclusive = true
                    }
                }
            } else {
                navController.navigate(Screen.NOTIFICATION.name) {
                    popUpTo(Screen.SIGNIN.name) {
                        inclusive = true
                    }
                }
            }
            Log.d("LOG" , tokenId)
        } ,
        onDialogDismissed = { message ->
            Log.d("LOG" , message)
            isLoading = false
        }
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier
            .background(Color(0xFF0DBDBDB))
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(300.dp),
            ) {
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.logo_icon) , contentDescription = null)

        }

        Spacer(modifier = Modifier.weight(3f))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally ,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Welcome to" , style = figmaTypography.displayMedium)
            Text(text = "Synth AI" , style = figmaTypography.displayLarge)
        }

        Spacer(modifier = Modifier.weight(2f))

        GoogleButton(
            onClick = {
                state.open()
                isLoading = !isLoading
            },
            isLoading = isLoading
        )
        PrivacyPolicy(
            privacyOnClick = {
                val intent = Intent(Intent.ACTION_VIEW , Uri.parse("https://www.google.com"))
                context.startActivity(intent)
            } ,
            termServiceOnClick = {
                val intent = Intent(Intent.ACTION_VIEW , Uri.parse("https://www.goog.com"))
                context.startActivity(intent)
            } ,
            stringIdRes = R.string.google_permission ,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }

}

@Preview
@Composable
private fun SignInPreview() {
}
