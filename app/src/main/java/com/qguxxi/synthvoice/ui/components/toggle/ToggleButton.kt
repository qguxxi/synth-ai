package com.qguxxi.synthvoice.ui.components.toggle

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.qguxxi.synthvoice.R
import com.qguxxi.synthvoice.ui.theme.figmaTypography

@Composable
fun ToggleDarkTheme(
) {
    var isDarkMode by remember { mutableStateOf(false) }

    val scheme = MaterialTheme.colorScheme

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = scheme.secondaryContainer , shape = RoundedCornerShape(topStart = 15.dp , topEnd = 15.dp , bottomStart = 5.dp , bottomEnd = 5.dp))
            .width(360.dp)
            .height(80.dp)
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.dark_theme),
                style = figmaTypography.displaySmall,
                color = scheme.onPrimaryContainer
                )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(id = R.string.dark_theme_des),
                style = figmaTypography.headlineSmall,
                color = scheme.onSecondaryContainer
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = isDarkMode,
            onCheckedChange = {
                isDarkMode = it
            }
        )
    }
}
@Composable
fun VersionDetail() {
    val scheme = MaterialTheme.colorScheme
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = scheme.secondaryContainer , shape = RoundedCornerShape(size = 10.dp))
            .width(360.dp)
            .height(80.dp)
            .padding(16.dp)
    ) {
        var checked by remember { mutableStateOf(false) }
        Column {
            Text(
                text = stringResource(id = R.string.version_1),
                style = figmaTypography.displaySmall,
                color = scheme.onPrimaryContainer
                )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(id = R.string.version_1_des),
                style = figmaTypography.headlineSmall,
                color = scheme.onSecondaryContainer
                )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = stringResource(id = R.string.version), style = figmaTypography.displaySmall)
    }
}

@Composable
fun ToggleChangeLanguage() {
    val scheme = MaterialTheme.colorScheme
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = scheme.secondaryContainer , shape = RoundedCornerShape(size = 10.dp))
            .width(360.dp)
            .height(80.dp)
            .padding(16.dp)
    ) {
        var checked by remember { mutableStateOf(false) }
        Column {
            Text(
                text = stringResource(id = R.string.change_language),
                style = figmaTypography.displaySmall,
                color = scheme.onPrimaryContainer
                )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(id = R.string.change_language_des),
                style = figmaTypography.headlineSmall,
                color = scheme.onSecondaryContainer
            )
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
    val scheme = MaterialTheme.colorScheme
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = scheme.secondaryContainer , shape = RoundedCornerShape(size = 10.dp))
            .width(360.dp)
            .height(80.dp)
            .padding(16.dp)
    ) {
        var checked by remember { mutableStateOf(false) }
        Column {
            Text(
                text = stringResource(id = R.string.log_out),
                style = figmaTypography.displaySmall,
                color = scheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(id = R.string.log_out_des),
                style = figmaTypography.headlineSmall,
                color = scheme.onSecondaryContainer
            )
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