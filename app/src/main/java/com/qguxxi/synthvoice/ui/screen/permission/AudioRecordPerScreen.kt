package com.qguxxi.synthvoice.ui.screen.permission

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
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
import com.qguxxi.synthvoice.ui.components.button.PermissionButton
import com.qguxxi.synthvoice.ui.components.under.PrivacyPolicy
import com.qguxxi.synthvoice.ui.theme.figmaTypography
import com.qguxxi.synthvoice.untils.permission.AudioRecordPermission

@Composable
fun AudioRecordScreen(navController: NavController,activity: Activity,modifier: Modifier) {
    Surface(
        modifier =  modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(3f))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(300.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.logo_icon) ,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground
                    )
            }
            Spacer(modifier = modifier.weight(5f))
            Text(
                text = "Interact Seamlessly with AI",
                style = figmaTypography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
                )   
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Voice Activated and Ready",
                style = figmaTypography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground
                )
            Spacer(modifier = modifier.weight(5f))
            PermissionButton(
                permClick = { AudioRecordPermission.checkAndRequestAudioPermission(navController = navController, activity = activity) },
                idIcon = R.drawable.volume_1,
                idString = R.string.audio_record,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(end = 16.dp)
            )
            PrivacyPolicy(
                privacyOnClick = { /*TODO*/ },
                termServiceOnClick = { /*TODO*/ },
                stringIdRes = R.string.audio_per,
                modifier = modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}


@Preview
@Composable
fun AudioScreenPreview() {
    AudioRecordScreen(navController = rememberNavController() , activity =  Activity(), modifier = Modifier)
}