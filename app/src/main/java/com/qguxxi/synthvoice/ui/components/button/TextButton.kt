package com.qguxxi.synthvoice.ui.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.TextButton
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qguxxi.synthvoice.ui.theme.backgroundDark

@Composable
fun TextButtonGo(onClick: () -> Unit,modifier: Modifier = Modifier) {
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            MaterialTheme.colorScheme.primaryContainer,MaterialTheme.colorScheme.onPrimaryContainer
        ),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(12.dp),
        modifier = Modifier
            .width(140.dp)
            .height(40.dp)
        ) {
        Text(
            text = "Let's Go",
            style = MaterialTheme.typography.labelMedium,
            )

    }
}

@Preview
@Composable
private fun TextButtonPreview() {
    TextButtonGo(onClick = { /*TODO*/ })
}