package com.example.composeloginscreeninit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.composeloginscreeninit.R
import com.example.composeloginscreeninit.screens.login.SocialMediaLogin

@Composable
fun SocialMediaSection(text: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF64748B))
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            SocialMediaLogin(
                icon = R.drawable.google,
                text = stringResource(id = R.string.google)
            ) { }
            Spacer(modifier = Modifier.width(20.dp))
            SocialMediaLogin(
                icon = R.drawable.facebook,
                text = stringResource(id = R.string.facebook)
            ) { }
        }
    }
}
