package com.qguxxi.synthvoice.ui.screen.home

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.qguxxi.synthvoice.R
import com.qguxxi.synthvoice.ui.theme.TapperTypography
import com.qguxxi.synthvoice.ui.theme.figmaTypography
import com.qguxxi.synthvoice.untils.TextToSpeechManager

@Composable
fun HomeScreen(
    viewModel: AIViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    context : Context
) {

    var userQuestion by remember { mutableStateOf("") }
    var aiAnswer by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val composition1 by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.gradient))
    val composition2 by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.record))
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(32.dp)
        ) {
            Text(
                text = stringResource(id = R.string.ai_warning_1) ,
                style = figmaTypography.titleSmall ,
                modifier = Modifier.graphicsLayer(alpha = 0.6f)
            )
            Text(
                text = stringResource(id = R.string.ai_warning_2) ,
                style = figmaTypography.titleSmall ,
                modifier = Modifier.graphicsLayer(alpha = 0.6f)
            )
        }
        Box(
            modifier = Modifier.size(300.dp)
        ) {
            LottieAnimation(
                composition = composition1,
                speed = 2.5f,
                iterations = LottieConstants.IterateForever
            )
        }
        Text(text = stringResource(id = R.string.ai), style = TapperTypography.bodyMedium)
        Spacer(modifier = Modifier.weight(3f))

        Button(
            onClick = {
                isLoading = true
                viewModel.sendToOpenAI(
                    userQuestion,
                    onResult = {
                        aiAnswer = it
                        TextToSpeechManager(context) // Đọc câu trả lời
                        isLoading = false
                    },
                    onError = {
                        aiAnswer = it
                        isLoading = false
                    }
                )
            }
        ) {
            Text(text = "Gửi câu hỏi")
        }
        if (isLoading) {
            CircularProgressIndicator()
        }
        Spacer(modifier = Modifier.weight(1f))
    }

}

@Preview(
    showBackground = true
)
@Composable
fun HomeScreenPreview() {

}