@file:Suppress("DEPRECATION" , "UNREACHABLE_CODE")

package com.qguxxi.synthvoice.ui.screen.signin

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.qguxxi.synthvoice.R
import com.qguxxi.synthvoice.navigation.Screen
import com.qguxxi.synthvoice.ui.components.button.GoogleButton
import com.qguxxi.synthvoice.ui.components.under.PrivacyPolicy
import com.qguxxi.synthvoice.ui.theme.figmaTypography
import com.stevdzasan.onetap.OneTapSignInWithGoogle
import com.stevdzasan.onetap.getUserFromTokenId
import com.stevdzasan.onetap.rememberOneTapSignInState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun SignInScreen(
    navController : NavController
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.gradient))

    var isAnimationPlaying by remember { mutableStateOf(true) }

    val state = rememberOneTapSignInState()

    OneTapSignInWithGoogle(
        state = state,
        clientId = "530061469984-tdkskmiae9u7i51i88l80hogja4b2sc0.apps.googleusercontent.com",
        onTokenIdReceived = { tokenId ->
            Log.d("LOG", tokenId)
            navController.navigate(Screen.NOTIFICATION.name) {
                popUpTo(Screen.SIGNIN.name) {
                    inclusive = true
                }
            }
        },
        onDialogDismissed = { message ->
            Log.d("LOG", message)
        }
    )



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFF0DBDBDB))
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Box(modifier = Modifier.size(300.dp)) {
            LottieAnimation(
                composition = composition,
                speed = 2.5f,
                iterations = if (isAnimationPlaying) 3  else 0
            )
        }

        Spacer(modifier = Modifier.weight(3f))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Welcome to", style = figmaTypography.displayMedium)
            Text(text = "Synth AI", style = figmaTypography.displayLarge)
        }

        Spacer(modifier = Modifier.weight(2f))

        GoogleButton(onClick = { state.open() })

        PrivacyPolicy(
            privacyOnClick = { /* Handle Privacy Policy */ },
            termServiceOnClick = { /* Handle Terms of Service */ },
            stringIdRes = R.string.google_permission,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }

}

@Preview
@Composable
private fun SignInPreview() {
    SignInScreen(navController = rememberNavController())
}
