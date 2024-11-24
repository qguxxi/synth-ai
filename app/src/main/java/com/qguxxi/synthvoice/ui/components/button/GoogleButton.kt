package com.qguxxi.synthvoice.ui.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
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
fun GoogleButton(onClick : () -> Unit ,isLoading:Boolean,modifier : Modifier = Modifier) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp) ,
        colors = ButtonColors(Color.Black , Color.White , Color.Black , Color.Black) ,
        modifier = Modifier
            .height(42.dp)
            .width(200.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center ,
            verticalAlignment = Alignment.CenterVertically ,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.weight(1f))
            if (!isLoading) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.google) ,
                    contentDescription = "google" ,
                )
            } else {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    color = Color.White,
                    strokeWidth = 2.dp,
                )
            }
            Spacer(modifier = modifier.weight(2f))
            Text(
                text = stringResource(id = R.string.google) ,
                style = figmaTypography.bodySmall ,
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview
@Composable
private fun GoogleButtonPreview() {
    GoogleButton({}, false)
}
