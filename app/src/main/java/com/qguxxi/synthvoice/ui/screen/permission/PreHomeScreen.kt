package com.qguxxi.synthvoice.ui.screen.permission

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
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
import com.qguxxi.synthvoice.ui.components.button.TextButtonGo
import com.qguxxi.synthvoice.ui.components.under.PrivacyPolicy
import com.qguxxi.synthvoice.ui.theme.figmaTypography

@Composable
fun PreHomeScreen(navController: NavController) {
    Surface(
        modifier =  Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(3f))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(300.dp)
            ) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.logo_icon) , contentDescription = null)
            }
            Spacer(modifier = Modifier.weight(5f))
            Text(text = "Interact Seamlessly with AI", style = figmaTypography.bodyMedium)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Voice Activated and Ready", style = figmaTypography.labelLarge)
            Spacer(modifier = Modifier.weight(5f))
            TextButtonGo(onClick = {
                navController.navigate(Screen.HOME.name) {
                    popUpTo(Screen.PREHOME.name) {
                        inclusive = true
                    }
                }
            })
            PrivacyPolicy(
                privacyOnClick = {
                    navController.navigate(Screen.HOME.name) {
                        popUpTo(Screen.PREHOME.name) {
                            inclusive = true
                        }
                } },
                termServiceOnClick = { /*TODO*/ },
                stringIdRes = R.string.pre_home,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
private fun PreHomePreview() {
    PreHomeScreen(navController = rememberNavController())
}