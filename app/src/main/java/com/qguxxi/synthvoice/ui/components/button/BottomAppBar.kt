package com.qguxxi.synthvoice.ui.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.qguxxi.synthvoice.R
import com.qguxxi.synthvoice.navigation.Screen

@Composable
fun BottomAppBar(navController: NavController) {
    // Lấy thông tin của màn hình hiện tại từ NavController
    val navBackStackEntry = navController.currentBackStackEntryAsState()

    // Lấy tên của màn hình hiện tại từ route
    val currentScreen = navBackStackEntry.value?.destination?.route

    // Tạo trạng thái selected để theo dõi màn hình hiện tại
    var selected by rememberSaveable {
        mutableStateOf(if (currentScreen == Screen.HOME.name) 0 else 1)
    }

    // Cập nhật lại trạng thái selected khi màn hình thay đổi
    LaunchedEffect(currentScreen) {
        selected = if (currentScreen == Screen.HOME.name) 0 else 1
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Biểu tượng Home
        IconButton(onClick = {
            selected = 0
            navController.navigate(Screen.HOME.name) {
                launchSingleTop = true
                // Đảm bảo rằng màn hình "Home" được đưa lên đầu stack
                popUpTo(Screen.SETTING.name) { inclusive = true }
            }
        }) {
            Icon(
                imageVector = if (selected == 0)
                    ImageVector.vectorResource(id = R.drawable.home_2)
                else
                    ImageVector.vectorResource(id = R.drawable.home),
                contentDescription = "Trang chủ"
            )
        }

        // Biểu tượng Settings
        IconButton(onClick = {
            selected = 1
            navController.navigate(Screen.SETTING.name) {
                launchSingleTop = true
                // Đảm bảo rằng màn hình "Settings" được đưa lên đầu stack
                popUpTo(Screen.HOME.name) { inclusive = true }
            }
        }) {
            Icon(
                imageVector = if (selected == 1)
                    ImageVector.vectorResource(id = R.drawable.layer_2)
                else
                    ImageVector.vectorResource(id = R.drawable.settings),
                contentDescription = "Cài đặt"
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    BottomAppBar(navController = rememberNavController())
}