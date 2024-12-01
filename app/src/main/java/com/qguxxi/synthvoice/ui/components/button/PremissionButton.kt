package com.qguxxi.synthvoice.ui.components.button

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun PermissionButton(permClick:() -> Unit, @StringRes idString: Int, @DrawableRes idIcon : Int, modifier: Modifier = Modifier) {
    val scheme = MaterialTheme.colorScheme

    Button(
        onClick = permClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonColors(scheme.primaryContainer, scheme.onPrimaryContainer,scheme.primaryContainer, scheme.primaryContainer),
        modifier = modifier
            .height(36.dp)
            .width(250.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(idIcon),
                contentDescription = "google",
                )
            Text(
                text = stringResource(id = idString),
                style = figmaTypography.labelSmall
            )
        }
    }
}

@Preview
@Composable
private fun IconPreview() {
    PermissionButton(permClick = { /*TODO*/ }, idIcon = R.drawable.notification, idString = R.string.google_permission)
}