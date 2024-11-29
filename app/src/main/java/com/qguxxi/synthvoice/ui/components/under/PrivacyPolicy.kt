package com.qguxxi.synthvoice.ui.components.under

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qguxxi.synthvoice.R
import com.qguxxi.synthvoice.ui.components.button.GoogleButton
import com.qguxxi.synthvoice.ui.theme.figmaTypography

@Composable
fun PrivacyPolicy(
    privacyOnClick: () -> Unit,
    termServiceOnClick: () -> Unit,
    @StringRes stringIdRes: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ellipse),
                contentDescription = null,
                tint = Color.Unspecified

            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = stringIdRes),
                style = figmaTypography.labelSmall.copy(Color.Black),
                modifier = Modifier.padding(18.dp)
            )
        }
        HorizontalDivider(color = Color.Black)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .alpha(0.5f)
        ) {
            Text(text = "By using the app, you accept our Terms of Service",
                style = figmaTypography.labelSmall.copy(color = Color.Black),
                )
            Text(text = "and acknowledge reading the Privacy Policy",
                style = figmaTypography.labelSmall.copy(color = Color.Black),
            )
        }
        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(onClick = privacyOnClick) {
                Text(
                    text = stringResource(id = R.string.privacy_policy),
                    style = figmaTypography.labelMedium.copy(Color.Black)
                )
            }
            VerticalDivider(modifier = Modifier.height(12.dp))
            TextButton(onClick = termServiceOnClick) {
                Text(
                    text = stringResource(id = R.string.terms_services),
                    style = figmaTypography.labelMedium.copy(Color.Black)
                )
            }
        }

    }
}

@Preview
@Composable
private fun PrivacyPolicyPreview() {
    GoogleButton(onClick = { /*TODO*/ }, isLoading = false)
    PrivacyPolicy(
        privacyOnClick = { /*TODO*/ },
        termServiceOnClick = { /*TODO*/ },
        stringIdRes = R.string.google_permission
    )
}