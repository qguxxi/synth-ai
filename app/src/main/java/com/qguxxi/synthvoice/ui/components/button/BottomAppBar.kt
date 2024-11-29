package com.qguxxi.synthvoice.ui.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.qguxxi.synthvoice.R
import com.qguxxi.synthvoice.navigation.Screen

@Composable
fun BottomAppBar(navController: NavController) {
    // Lấy thông tin màn hình hiện tại từ NavController
    val currentDestination = navController.currentDestination

    // Kiểm tra nếu đang ở màn hình Home
    val isHomeScreen = currentDestination?.route == Screen.HOME.name
    // Kiểm tra nếu đang ở màn hình Settings
    val isSettingsScreen = currentDestination?.route == Screen.SETTING.name

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Biểu tượng Home
        IconButton(
            onClick = {
                if (!isHomeScreen) { // Chỉ thực hiện điều hướng nếu không phải đang ở màn hình Home
                    navController.navigate(Screen.HOME.name) {
                        launchSingleTop = true
                        // Đảm bảo rằng màn hình "Home" được đưa lên đầu stack
                        popUpTo(Screen.SETTING.name) { inclusive = true }
                    }
                }
            },
            enabled = !isHomeScreen // Vô hiệu hóa nếu đang ở màn hình Home
        ) {
            Icon(
                imageVector = if (isHomeScreen)
                    ImageVector.vectorResource(id = R.drawable.home_2)
                else
                    ImageVector.vectorResource(id = R.drawable.home),
                contentDescription = "Trang chủ",
                tint = Color.Unspecified
            )
        }

        // Biểu tượng Settings
        IconButton(
            onClick = {
                if (!isSettingsScreen) { // Chỉ thực hiện điều hướng nếu không phải đang ở màn hình Settings
                    navController.navigate(Screen.SETTING.name) {
                        launchSingleTop = true
                        // Đảm bảo rằng màn hình "Settings" được đưa lên đầu stack
                        popUpTo(Screen.HOME.name) { inclusive = true }
                    }
                }
            },
            enabled = !isSettingsScreen // Vô hiệu hóa nếu đang ở màn hình Settings
        ) {
            Icon(
                imageVector = if (isSettingsScreen)
                    ImageVector.vectorResource(id = R.drawable.layer_2)
                else
                    ImageVector.vectorResource(id = R.drawable.settings),
                contentDescription = "Cài đặt",
                tint = Color.Unspecified
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    BottomAppBar(navController = rememberNavController())
}