package com.qguxxi.synthvoice.ui.components.toggle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qguxxi.synthvoice.R
import com.qguxxi.synthvoice.ui.theme.figmaTypography

@Composable
fun ToggleDarkTheme() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = Color(0xFFC2C2C2) , shape = RoundedCornerShape(topStart = 15.dp , topEnd = 15.dp , bottomStart = 5.dp , bottomEnd = 5.dp))
            .width(360.dp)
            .height(80.dp)
            .padding(16.dp)
    ) {
        var checked by remember { mutableStateOf(false) }
        Column {
            Text(text = stringResource(id = R.string.dark_theme), style = figmaTypography.displaySmall)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = stringResource(id = R.string.dark_theme_des), style = figmaTypography.headlineSmall)
        }
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = checked ,
            onCheckedChange = { checked = it}
        )
    }
}
@Composable
fun VersionDetail() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = Color(0xFFC2C2C2) , shape = RoundedCornerShape(size = 10.dp))
            .width(360.dp)
            .height(80.dp)
            .padding(16.dp)
    ) {
        var checked by remember { mutableStateOf(false) }
        Column {
            Text(text = stringResource(id = R.string.change_language), style = figmaTypography.displaySmall)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = stringResource(id = R.string.change_language_des), style = figmaTypography.headlineSmall)
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = stringResource(id = R.string.version), style = figmaTypography.displaySmall)
    }
}

@Composable
fun ToggleChangeLanguage() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = Color(0xFFC2C2C2) , shape = RoundedCornerShape(size = 10.dp))
            .width(360.dp)
            .height(80.dp)
            .padding(16.dp)
    ) {
        var checked by remember { mutableStateOf(false) }
        Column {
            Text(text = stringResource(id = R.string.change_language), style = figmaTypography.displaySmall)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = stringResource(id = R.string.change_language_des), style = figmaTypography.headlineSmall)
        }
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = checked ,
            onCheckedChange = { checked = it}
        )
    }
}

@Composable
fun LogOut() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = Color(0xFFC2C2C2) , shape = RoundedCornerShape(size = 10.dp))
            .width(360.dp)
            .height(80.dp)
            .padding(16.dp)
    ) {
        var checked by remember { mutableStateOf(false) }
        Column {
            Text(text = stringResource(id = R.string.log_out), style = figmaTypography.displaySmall)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = stringResource(id = R.string.log_out_des), style = figmaTypography.headlineSmall)
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.next) , contentDescription = null)
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun TogglePreview() {

}