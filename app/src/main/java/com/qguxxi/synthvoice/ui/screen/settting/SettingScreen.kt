package com.qguxxi.synthvoice.ui.screen.settting

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.qguxxi.synthvoice.ui.components.button.BottomAppBar
import com.qguxxi.synthvoice.ui.components.connect.ConnectWidget
import com.qguxxi.synthvoice.ui.components.toggle.LogOut
import com.qguxxi.synthvoice.ui.components.toggle.ToggleChangeLanguage
import com.qguxxi.synthvoice.ui.components.toggle.ToggleDarkTheme
import com.qguxxi.synthvoice.ui.components.toggle.VersionDetail

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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(it).fillMaxSize()
            ) {
                ToggleDarkTheme()
                ToggleChangeLanguage()
                VersionDetail()
                LogOut()
                ConnectWidget(context = context)
            }
        }
    )
}

@Preview
@Composable
private fun SettingScreenPreview() {
    SettingScreen(navController = rememberNavController(), context = LocalContext.current)
}