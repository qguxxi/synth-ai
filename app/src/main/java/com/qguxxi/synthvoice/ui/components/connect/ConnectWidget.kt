package com.qguxxi.synthvoice.ui.components.connect

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qguxxi.synthvoice.R

@Composable
fun ConnectWidget(context: Context , modifier : Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .width(240.dp)
            .height(80.dp)
            .background(color = Color(0xB2C2C2C2) , shape = RoundedCornerShape(size = 10.dp))
            .padding(start = 21.dp , top = 14.dp , end = 21.dp , bottom = 6.dp)
    ) {
        Text(text = "Connect with me")
        Row {
            IconButton(onClick = {
                    val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/profile.php?id=100046125108448&locale=vi_VN"))
                context.startActivity(intent)
            }) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.meta_platforms) , contentDescription = null)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.github) , contentDescription = null)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.telegram) , contentDescription = null)
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {

}