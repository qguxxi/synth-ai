package com.qguxxi.synthvoice.ui.screen.settting

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.qguxxi.synthvoice.ui.components.button.BottomAppBar
import com.qguxxi.synthvoice.ui.components.connect.ConnectWidget
import com.qguxxi.synthvoice.ui.components.toggle.LogOut
import com.qguxxi.synthvoice.ui.components.toggle.ToggleChangeLanguage
import com.qguxxi.synthvoice.ui.components.toggle.ToggleDarkTheme
import com.qguxxi.synthvoice.ui.components.toggle.VersionDetail
import com.qguxxi.synthvoice.ui.theme.figmaTypography

@Composable
fun SettingScreen(context : Context,navController : NavController) {
    Scaffold(
        bottomBar = {
            Row(
                horizontalArrangement = Arrangement.Center ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                BottomAppBar(
                    navController = navController ,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        } ,
        content = {
            Surface(
                color = MaterialTheme.colorScheme.surface
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Synth AI",
                        style = figmaTypography.displayLarge.copy(fontSize = 48.sp),
                        modifier = Modifier.padding(24.dp)
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally ,
                        verticalArrangement = Arrangement.spacedBy(12.dp) ,
                        modifier = Modifier
                            .padding(it)
                    ) {
                        ToggleDarkTheme()
                        ToggleChangeLanguage()
                        VersionDetail()
                        LogOut()
                        ConnectWidget(context = context)
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun SettingScreenPreview() {
    SettingScreen(navController = rememberNavController(), context = LocalContext.current)
}